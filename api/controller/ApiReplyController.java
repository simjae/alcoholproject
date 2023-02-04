package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiNotificationDao;
import com.bvdev.alcoholproject.api.dao.ApiReplyDao;
import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.ActivityParamDto;
import com.bvdev.alcoholproject.api.dto.ApiReplyListDto;
import com.bvdev.alcoholproject.api.dto.NotificationDto;
import com.bvdev.alcoholproject.api.dto.ReplyDto;
import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.common.util.VerifyUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiReplyController {
	
	@Inject
	private ApiActivityDao apiActivityDao;
	
	@Inject
	private ApiNotificationDao apiNotificationDao;
	
	@Inject
	private ApiReplyDao apiReplyDao;
	
	@Inject
	private MemberUtil memberUtil;
	
	@Inject
	private VerifyUtil verifyUtil;


	@ApiOperation(value = "Reply List belong to Origin Feed", notes = "Reply List belong to Origin Feed")
	@GetMapping(value = "/common/reply")
	public Map<String, Object> selectTblActivityByMpttLeft(
		//TBL_ACTIVITY.idx
		@RequestParam int primaryIdx,
		@RequestParam int secondaryIdx,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		Boolean tblActivityReplyFlg = false;
		
		ApiReplyListDto apiReplyListDto = new ApiReplyListDto();
		
		ActivityDto activityDto = new ActivityDto();
		if (primaryIdx > secondaryIdx) {
			activityDto.setPrimaryIdx(primaryIdx);
		} else {
			activityDto.setSecondaryIdx(secondaryIdx);
		}
		
		//selectTblActivityByPrimaryIdx : 원글에 속해있는 댓글 idx 리스트 | return type: List<integer>
		List<Integer> mpttLeftList = apiReplyDao.selectTblActivityByPrimaryIdx(activityDto);
		
		//selectTblActivityByMpttLeft : parameter List<integer>값에 속하는 idx의 activityDto 리스트 | return type : List<ActivityDto>
		if(mpttLeftList.size() > 0) {
			tblActivityReplyFlg = true;
			
			HttpSession session = request.getSession();
			int memberIdx = (int)session.getAttribute("idx");
			
			ReplyDto paramDto = new ReplyDto();
			paramDto.setMemberIdx(memberIdx);
			paramDto.setMpttLeftList(mpttLeftList);
			paramDto.setOrderFlg(false);
			
			List<ReplyDto> replyDtoList = apiReplyDao.selectReplyInfoList(paramDto);
			
			if (replyDtoList.size() > 0) {
				for (int i=0; i<replyDtoList.size(); i++) {
					Boolean likeFlg = replyDtoList.get(i).getLikeFlg();
					String likeImg = null;
					if (likeFlg == true) {
						likeImg = "/alcoholProject/images/common/full_heart.svg";
					} else {
						likeImg = "/alcoholProject/images/common/empty_heart.svg";
					}
					replyDtoList.get(i).setLikeImg(likeImg);
				}
				
				apiReplyListDto.setReplyDtoList(replyDtoList);
			}
		}
		
		Map<String, Object> apiResult = new HashMap<>();
		
		if (tblActivityReplyFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동의 댓글을 정상적으로 취득했습니다.");
			apiResult.put("replyInfo",apiReplyListDto);
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동의 댓글 취득에 실패했습니다.");
		}

		return apiResult;
	}
	

	@ApiOperation(value = "INSERT TBL_ACTIVITY REPLY INFO", notes = "INSERT TBL_ACTIVITY REPLY INFO")
	@PostMapping(value = "/activity/reply")
	public Map<String, String> insertTblActivityReply(
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam int parentsIdx,		//TBL_ACTIVITY.idx - parent activity idx
		@RequestParam String content,		//TBL_ACTIVITY.content
		@RequestParam String mentionIdList,	//TBL_NOTIFICATION.member_id
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {

		int memberIdx = 0;
		if (memberId != null && !memberId.isEmpty()) {
			memberIdx = memberUtil.getMemberIdx(memberId);
		}
		
		//TBL_ACTIVITY 등록 확인용 플래그
		Boolean tblActivityResultFlg = false;
		//TBL_NOTIFICATION 등록 확인용 플래그
		Boolean tblNotificationResultFlg = true;
		
		int commentNum = 0;
		if (parentsIdx > 0){
			ActivityParamDto paramDto = new ActivityParamDto();
			paramDto.setActivityIdx(parentsIdx);
			
			ActivityDto parentsInfo = apiActivityDao.selectTblActivityByIdx(paramDto);
			
			int mpttLeft = 0;
			
			if(parentsInfo.getMpttLeft() == 0 && parentsInfo.getMpttRight() == 0) {
				apiReplyDao.updateTblActivityMpttByIdx(parentsIdx);
				mpttLeft = 2;
			} else {
				mpttLeft = apiReplyDao.selectTblActivityMaxChildMpttByIdx(parentsInfo.getIdx());
			}
			
			ActivityDto activityDto = new ActivityDto();
			activityDto.setGroupIdx(0);
			activityDto.setMemberIdx(memberIdx);
			activityDto.setType("activity");
			activityDto.setAction("activity_comment");
			activityDto.setActivityHiddenFlg(false);
			activityDto.setActivityGrade("0.0");
			activityDto.setCreater(memberId);
			activityDto.setUpdater(memberId);
			
			activityDto.setNoticeLink("-");
			
			if (content != null && !content.isEmpty()) {
				content = content.replaceAll("\n\r", "<br>");
				activityDto.setContent(content);
			}
			
			activityDto.setMpttLeft(mpttLeft);
			activityDto.setMpttRight(mpttLeft + 1);
			
			//원글이 아닌 댓글이라면 PrimaryIdx값을, 
			//원글이라면 idx값을 새로운 댓글의 PrimaryIdx로 지정한다.
			int primaryIdx = 0;
			if(parentsInfo.getPrimaryIdx() > 0) {
				primaryIdx = parentsInfo.getPrimaryIdx();
			} else {
				primaryIdx = parentsInfo.getIdx();
			}
			
			activityDto.setPrimaryIdx(primaryIdx);
			
			//부모 글&댓글의 값을 SecondaryIdx으로 지정한다.
			activityDto.setSecondaryIdx(parentsInfo.getIdx());
			
			//추가된 댓글 mptt값에 따른 나머지 댓글&원글의 mptt값 업데이트
			int activityIdx = apiActivityDao.insertTblActivity(activityDto);
			
			if(activityIdx > 0) {
				tblActivityResultFlg = true;
				
				commentNum = apiReplyDao.selectReplyCommentCntByActivityIdx(parentsIdx);
				
				activityDto.setIdx(activityIdx);
				apiReplyDao.updateTblActivityMptt(activityDto);
				
				NotificationDto notificationDto = new NotificationDto();
				notificationDto.setMemberIdx(memberIdx);
				notificationDto.setActivityIdx(activityIdx);
				notificationDto.setCreater(memberId);
				int notificationIdx = apiNotificationDao.insertTblNotification(notificationDto);
				
				if (notificationIdx > 0 && mentionIdList != null && !mentionIdList.isEmpty()) {
					tblNotificationResultFlg = verifyUtil.verifyMemberMentionId(mentionIdList, memberId, activityIdx);
				}
			}
		}
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (tblActivityResultFlg == true && tblNotificationResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("commentNum",String.valueOf(commentNum));
			apiResult.put("message", "활동이 정상적으로 생성되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 등록에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "SELECT TBL_PRODUCT REVIEW", notes = "SELECT TBL_PRODUCT_REVIEW")
	@GetMapping(value = "/product/review/order")
	public Map<String, Object> selectProductReviewByOrder(
		@RequestParam int productIdx,		//TBL_RPODUCT.idx
		@RequestParam Boolean orderFlg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		ReplyDto paramDto = new ReplyDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setProductIdx(productIdx);
		paramDto.setOrderFlg(orderFlg);
		
		List<ReplyDto> replyDtoList = apiReplyDao.selectReplyInfoList(paramDto);
		
		if (replyDtoList.size() > 0) {
			for (int i=0; i<replyDtoList.size(); i++) {
				Boolean likeFlg = replyDtoList.get(i).getLikeFlg();
				String likeImg = "";
				
				if (likeFlg == true) {
					likeImg = "/alcoholProject/images/common/full_heart.svg";
				} else {
					likeImg = "/alcoholProject/images/common/empty_heart.svg";
				}
				replyDtoList.get(i).setLikeImg(likeImg);
			}
		}
		
		Map<String, Object> apiResult = new HashMap<>();
		
		if (replyDtoList.size() > 0) {
			apiResult.put("result", "200");
			apiResult.put("replyInfoList", replyDtoList);
			apiResult.put("message", "상품의 리뷰를 정상적으로 취득했습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "상품의 리뷰 취득에 실패했습니다.");
		}
		return apiResult;
	}
}