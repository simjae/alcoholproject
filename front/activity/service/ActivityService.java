package com.bvdev.alcoholproject.front.activity.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityFoodDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityProductDao;
import com.bvdev.alcoholproject.api.dao.ApiMediaDao;
import com.bvdev.alcoholproject.api.dao.ApiNotificationDao;
import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.ActivityParamDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.MediaDto;
import com.bvdev.alcoholproject.api.dto.NotificationDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.common.util.MessageUtils;
import com.bvdev.alcoholproject.front.activity.vo.ActivityFormVo;
import com.bvdev.alcoholproject.front.activity.vo.UpdateFormVo;

@Service
public class ActivityService {

	@Inject
	private ApiActivityDao apiActivityDao;
	
	@Inject
	private ApiMediaDao apiMediaDao;

	@Inject
	private ApiActivityProductDao apiActivityProductDao;
	
	@Inject
	private ApiActivityFoodDao apiActivityFoodDao;
	
	@Inject
	private ApiNotificationDao apiNotificationDao;
	
	@Inject
	private MemberUtil memberUtil;
	
	public void insertTblActivity(ActivityDto activityDto) throws Exception {
		
		int errCnt = 0;

		// 예외처리 : PARAM - ACTIVITYDTO
		if (activityDto == null) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.ACTIVITYDTO"});			
		}

		// 예외처리 : PARAM - GROUP_IDX
		if (activityDto.getGroupIdx() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.GROUP_IDX"});
		}
		
		// 예외처리 : PARAM - MEMBER_IDX
		if (activityDto.getMemberIdx() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		// 예외처리 : PARAM - TYPE
		if (activityDto.getType() == null || activityDto.getType().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.TYPE"});
		}
		
		// 예외처리 : PARAM - ACTION
		if (activityDto.getAction() == null || activityDto.getAction().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.ACTION"});
		}
		
		// 예외처리 : PARAM - CONTENT
		if (activityDto.getContent() == null || activityDto.getContent().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.CONTENT"});
		}
		
		// 예외처리 : PARAM - PRIMARY_IDX
		if (activityDto.getPrimaryIdx() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.PRIMARY_IDX"});
		}
		
		// 예외처리 : PARAM - SECONDARY_IDX
		if (activityDto.getSecondaryIdx() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.SECONDARY_IDX"});
		}
		
		// 예외처리 : PARAM - MPTT_LEFT
		if (activityDto.getMpttLeft() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MPTT_LEFT"});
		}
		
		// 예외처리 : PARAM - MPTT_RIGHT
		if (activityDto.getMpttRight() < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MPTT_RIGHT"});
		}
		
		// 예외처리 : PARAM - CREATER
		if (activityDto.getCreater() == null || activityDto.getCreater().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.CREATER"});
		}
		
		// 예외처리 : PARAM - UPDATER
		if (activityDto.getUpdater() == null || activityDto.getUpdater().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.UPDATER"});
		}
		
		try {
			if (errCnt == 0) {
				apiActivityDao.insertTblActivity(activityDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ActivityFormVo activityForm(String memberId, int activityIdx) throws Exception {
		ActivityFormVo activityFormVo = new ActivityFormVo();
		
		activityFormVo.setMemberId(memberId);
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		if (activityIdx > 0) {
			ActivityParamDto paramDto = new ActivityParamDto();
			paramDto.setActivityIdx(activityIdx);
			paramDto.setMemberIdx(memberIdx);

			ActivityDto activityDto = apiActivityDao.selectTblActivityByIdx(paramDto);
			
			if (activityDto != null) {
				activityFormVo.setActivityDto(activityDto);
				
				List<MediaDto> mediaDtoList = apiMediaDao.selectTblMediaListByActivityIdx(activityIdx);
				if (mediaDtoList.size() > 0) {
					activityFormVo.setMediaDtoList(mediaDtoList);
				}
				
				Boolean likeFlg = activityDto.getLikeFlg();
				String likeImg = "";
				if (likeFlg == true) {
					likeImg = "/alcoholProject/images/common/full_heart.svg";
				} else {
					likeImg = "/alcoholProject/images/common/empty_heart.svg";
				}
				activityFormVo.setLikeImg(likeImg);
				
				List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectTblFoodInfoListByActivityIdx(activityIdx);
				
				String activityFoodName = "-";
				if (foodInfoDtoList.size() > 0) {
					for (int i=0; i<foodInfoDtoList.size(); i++) {
						String foodName = foodInfoDtoList.get(i).getFoodName();
						
						if (i == 0) {
							activityFoodName = foodName;
						} else {
							activityFoodName += (", " + foodName);
						}
						
					}
				}
				activityFormVo.setActivityFoodName(activityFoodName);
				
				List<NotificationDto> notificationDtoList = apiNotificationDao.selectTblNotificationListByActivityIdx(activityIdx);
				if (notificationDtoList.size() > 0) {
					activityFormVo.setNotificationDtoList(notificationDtoList);
				}
			}
		}
		
		return activityFormVo;
	}
	
	public UpdateFormVo updateActivityForm(String memberId, int activityIdx) throws Exception {
		UpdateFormVo updateFormVo = new UpdateFormVo();
		
		int errCnt = 0;
		// 예외처리 : PARAM - MEMBER_ID
		if (memberId == null || memberId.isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.MEMBER_ID"});
		}
		
		// 예외처리 : PARAM - ACTIVITY_IDX
		if (activityIdx < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.ACTIVITY_IDX"});
		}
		
		if (errCnt == 0) {
			updateFormVo.setMemberId(memberId);
			
			ActivityParamDto paramDto = new ActivityParamDto();
			paramDto.setActivityIdx(activityIdx);
			
			ActivityDto activityDto = apiActivityDao.selectTblActivityByIdx(paramDto);
			
			if (activityDto != null) {
				List<MediaDto> mediaDtoList = apiMediaDao.selectTblMediaListByActivityIdx(activityIdx);
				
				if (mediaDtoList.size() > 0) {
					updateFormVo.setMediaDtoList(mediaDtoList);
					
					String filenameArr = "";
					for (int i=0; i<mediaDtoList.size(); i++) {
						String tempFilename = mediaDtoList.get(i).getOriginMediaFilename();
						filenameArr += (tempFilename + ",");
					}
					filenameArr = StringUtils.substring(filenameArr,0,-1);
					
					if (filenameArr.length() > 0) {
						updateFormVo.setFilenameArr(filenameArr);
					}
				}
				
				int productIdx = activityDto.getProductIdx();
				if (productIdx > 0) {
					ProductDto productDto = apiActivityProductDao.selectActivityProductByIdx(productIdx);
					
					if (productDto != null) {
						updateFormVo.setProductNameKor(productDto.getProductNameKor());
						updateFormVo.setProductNameEng(productDto.getProductNameEng());
						updateFormVo.setSellPrice(productDto.getSellPrice());
					}
				}
				
				int activityFoodIdx = activityDto.getActivityFoodIdx();
				if (activityFoodIdx > 0) {
					List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectTblFoodInfoListByActivityIdx(activityIdx); 
					
					String foodInfoIdxList = "";
					if (foodInfoDtoList.size() > 0) {
						updateFormVo.setFoodInfoDtoList(foodInfoDtoList);
						
						for (int i=0; i<foodInfoDtoList.size(); i++) {
							foodInfoIdxList += (foodInfoDtoList.get(i).getIdx() + ",");
						}
						
						foodInfoIdxList = foodInfoIdxList.substring(0, (foodInfoIdxList.length() - 1));
						if (foodInfoIdxList.length() > 0) {
							updateFormVo.setFoodInfoIdxList(foodInfoIdxList);
						}
						
					}
				}
				
				List<NotificationDto> notificationDtoList = apiNotificationDao.selectTblNotificationListByActivityIdx(activityIdx);
				
				if (notificationDtoList.size() > 0) {
					String mentionIdList = "";
					for (int i=0; i<notificationDtoList.size(); i++) {
						String mentionId = "@" + notificationDtoList.get(i).getMemberId() + " ";
						mentionIdList += mentionId;
					}
					
					updateFormVo.setMentionIdList(mentionIdList);
				}
				
				updateFormVo.setActivityDto(activityDto);
			}
		}
		
		return updateFormVo;
	}
}