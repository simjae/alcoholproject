package com.bvdev.alcoholproject.api.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiActivityAddrDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityFoodDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityProductDao;
import com.bvdev.alcoholproject.api.dao.ApiNotificationDao;
import com.bvdev.alcoholproject.api.dao.ApiTblLogDao;
import com.bvdev.alcoholproject.api.dto.ActivityAddrDto;
import com.bvdev.alcoholproject.api.dto.ActivityAddrLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.ActivityFoodLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityParamDto;
import com.bvdev.alcoholproject.api.dto.CalendarDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.NotificationDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.common.util.ConvertDtoListToJson;
import com.bvdev.alcoholproject.common.util.ConvertDtoToJson;
import com.bvdev.alcoholproject.common.util.ConvertUtil;
import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.common.util.VerifyUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiActivityController {
	@Inject
	private ApiActivityDao apiActivityDao;
	
	@Inject
	private ApiActivityProductDao apiActivityProductDao;
	
	@Inject
	private ApiActivityAddrDao apiActivityAddrDao;
	
	@Inject
	private ApiActivityFoodDao apiActivityFoodDao;
	
	@Inject
	private ApiNotificationDao apiNotificationDao;
	
	@Inject
	private ApiTblLogDao apiTblLogDao;
	
	@Inject
	private MemberUtil memberUtil;
	
	@Inject
	private ConvertUtil convertUtil;
	
	@Inject
	private VerifyUtil verifyUtil;
	
	@ApiOperation(value = "INSERT TBL_ACTIVITY ACTIVITY INFO", notes = "INSERT TBL_ACTIVITY ACTIVITY INFO")
	@PostMapping(value = "/activity/regist")
	public Map<String, String> insertTblActivity(
		@RequestParam String memberId,				//TBL_MEMBER.id,
		@RequestParam int productIdx,				//TBL_PRODUCT.IDX,
		@RequestParam int activityAddrIdx,			//TBL_ACTIVITY_ADDR.idx,
		@RequestParam String foodInfoIdxList,		//TBL_ACTIVITY_FOOD.food_info_idx,
		@RequestParam String content,				//TBL_ACTIVITY.content,
		@RequestParam String filenameArr,			//TBL_MEDIA.origin_media_filename,
		@RequestParam String mentionIdList,			//TBL_NOTIFICATION.member_id,
		@RequestParam String activityGrade,			//TBL_ACTIVITY.grade,
		@RequestParam Boolean activityHiddenFlg,	//TBL_activity.activity_hidden_flg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = memberUtil.getMemberIdx(memberId);

		//TBL_ACTIVITY 등록 확인용 플래그
		Boolean tblActivityResultFlg = false;
		//TBL_ACTIVITY_FOOD 등록 확인용 플래그
		Boolean tblActivityFoodResultFlg = true;
		//TBL_ACTIVITY_ADDR 등록 확인용 플래그
		Boolean tblActivityAddrResultFlg = true;
		//TBL_MEDIA 등록 확인용 플래그
		Boolean tblMediaResultFlg = true;
		//TBL_NOTIFICATION 등록 확인용 플래그
		Boolean tblNotificationResultFlg = true;
		//TBL_ACTIVITY_PRODUCT_LOG 등록 확인용 플래그
		Boolean tblProductResultFlg = true;
		
		//TBL_ACTIVITY 등록 처리
		ActivityDto activityDto = new ActivityDto();

		activityDto.setGroupIdx(0);
		activityDto.setMemberIdx(memberIdx);
		activityDto.setProductIdx(productIdx);
		activityDto.setType("activity");
		activityDto.setAction("activity_update");
		activityDto.setActivityHiddenFlg(activityHiddenFlg);
		
		//Activity Notice Link Logic
		activityDto.setNoticeLink("-");
		
		if (content != null && !content.isEmpty()) {
			content = content.replaceAll("\n\r", "<br>");
			activityDto.setContent(content);
		}
		
		if (activityAddrIdx > 0) {
			tblActivityAddrResultFlg = verifyUtil.verifyActivityAddr(memberId, activityAddrIdx);
			if (tblActivityAddrResultFlg == true) {
				activityDto.setActivityAddrIdx(activityAddrIdx);
			}
		}
		
		int activityFoodIdx = 0;
		if (foodInfoIdxList.length() > 0) {
			activityFoodIdx = verifyUtil.verifyActivityFood(memberId, activityFoodIdx, foodInfoIdxList);
			if (activityFoodIdx > 0) {
				tblActivityAddrResultFlg = true;
				activityDto.setActivityFoodIdx(activityFoodIdx);
			}
		}
		
		if (activityGrade != null && !activityGrade.isEmpty()) {
			if (activityGrade.length() == 1) {
				activityGrade += ".0";
			}
			activityDto.setActivityGrade(activityGrade);
		}
		
		activityDto.setCreater(memberId);
		activityDto.setUpdater(memberId);
		
		int activityIdx = apiActivityDao.mergeTblActivity(activityDto);
		
		if(activityIdx > 0) {
			tblActivityResultFlg = true;
			
			if (filenameArr != null && !filenameArr.isEmpty()) {
				tblMediaResultFlg = verifyUtil.verifyRegistMedia(memberId, activityIdx, filenameArr);
			}
			
			tblProductResultFlg = verifyUtil.verifyActivityProduct(memberId, productIdx);
			
			if (mentionIdList != null && !mentionIdList.isEmpty()) {
				tblNotificationResultFlg = verifyUtil.verifyMemberMentionId(mentionIdList, memberId, activityIdx);
			}
		}

		Map<String, String> apiResult = new HashMap<>();
		
		if (tblActivityResultFlg == true && tblActivityAddrResultFlg == true && tblActivityFoodResultFlg == true  && tblMediaResultFlg == true && tblNotificationResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동이 정상적으로 생성되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 등록에 실패했습니다.");
		}
		return apiResult;
	}

	@ApiOperation(value = "UPDATE TBL_ACTIVITY", notes = "UPDATE TBL_ACTIVITY")
	@PostMapping(value = "/activity/modify")
	public Map<String, String> updateTblActivity(
		@RequestParam String memberId,				//TBL_MEMBER.id,
		@RequestParam int activityIdx,				//TBL_ACTIVITY.idx,
		@RequestParam int productIdx,				//TBL_PRODUCT.idx,
		@RequestParam int activityAddrIdx,			//TBL_ACTIVITY_ADDR.idx,
		@RequestParam int activityFoodIdx,			//TBL_ACTIVITY_FOOD.idx
		@RequestParam String foodInfoIdxList,		//TBL_ACTIVITY_FOOD.food_info_idx,
		@RequestParam String content,				//TBL_ACTIVITY.content,
		@RequestParam String filenameArr,			//TBL_MEDIA.origin_media_filename,
		@RequestParam String mentionIdList,			//TBL_NOTIFICATION.member_id,
		@RequestParam String activityGrade,			//TBL_ACTIVITY.grade,
		@RequestParam Boolean activityHiddenFlg,	//TBL_ACTIVITY.activity_hidden_flg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		//TBL_ACTIVITY 갱신 확인용 플래그
		Boolean tblActivityResultFlg = false;
		//TBL_PRODUCT 갱신 확인용 플래그
		Boolean tblProductResultFlg = true;
		//TBL_ACTIVITY_ADDR 갱신 확인용 플래그
		Boolean tblActivityAddrResultFlg = true;
		//TBL_MEDIA 갱신 확인용 플래그
		Boolean tblMediaResultFlg = true;
		//TBL_NOTIFICATION 등록 확인용 플래그
		Boolean tblNotificationResultFlg = true;
		
		//TBL_ACTIVITY 갱신처리
		ActivityDto activityDto = new ActivityDto();

		if (activityIdx > 0) {
			activityDto.setIdx(activityIdx);
			
			if (content != null && !content.isEmpty()) {
				content.replaceAll("\n", "<br>");
				activityDto.setContent(content);
			}
			
			tblProductResultFlg = verifyUtil.verifyActivityProduct(memberId, productIdx);
			if (tblProductResultFlg == true) {
				activityDto.setProductIdx(productIdx);
			}
			
			if (activityAddrIdx > 0) {
				tblActivityAddrResultFlg = verifyUtil.verifyActivityAddr(memberId, activityAddrIdx);
				if (tblActivityAddrResultFlg == true) {
					activityDto.setActivityAddrIdx(activityAddrIdx);
				}
			}
			
			if (activityFoodIdx > 0) {
				if (foodInfoIdxList.length() > 0) {
					activityFoodIdx = verifyUtil.verifyActivityFood(memberId, activityFoodIdx, foodInfoIdxList);
				} else {
					apiActivityFoodDao.deleteTblActivityFoodByIdx(activityFoodIdx);
					activityFoodIdx = 0;
				}
				
				activityDto.setActivityFoodIdx(activityFoodIdx);
			}
			
			if (activityGrade != null && !activityGrade.isEmpty()) {
				if (activityGrade != null && !activityGrade.isEmpty()) {
					if (activityGrade.length() == 1) {
						activityGrade += ".0";
					}
					activityDto.setActivityGrade(activityGrade);
				}
			}

			if (memberId != null && !memberId.isEmpty()) {
				activityDto.setUpdater(memberId);
			}
			
			if (activityHiddenFlg != null) {
				activityDto.setActivityHiddenFlg(activityHiddenFlg);
			}

			int activityResultCount = apiActivityDao.updateTblActivityByIdx(activityDto);

			if (activityResultCount > 0) {
				//TBL_ACTIVITY 갱신 : TRUE
				tblActivityResultFlg = true;
				
				if (filenameArr != null && !filenameArr.isEmpty()) {
					tblMediaResultFlg = verifyUtil.verifyRegistMedia(memberId, activityIdx, filenameArr);
				}
				
				if (mentionIdList != null && !mentionIdList.isEmpty()) {
					tblNotificationResultFlg = verifyUtil.verifyMemberMentionId(mentionIdList, memberId, activityIdx);
				}
			}
		}
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (tblActivityResultFlg == true && tblProductResultFlg == true && tblActivityAddrResultFlg == true && tblMediaResultFlg == true && tblNotificationResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동이 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 갱신에 실패했습니다.");
		}
		
		return apiResult;
	}

	@ApiOperation(value = "DELETE TBL_ACTIVITY", notes = "DELETE TBL_ACTIVITY")
	@GetMapping(value = "/activity/drop")
	public Map<String, String> deleteTblActivityByIdx(
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam int activityIdx,		//TBL_ACTIVITY.idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		//TBL_ACTIVITY 갱신 확인용 플래그
		Boolean tblActivityResultFlg = false;
		//TBL_MEDIA 등록 확인용 플래그 
		Boolean tblMediaResultFlg = true;
		
		//TBL_ACTIVITY 갱신 처리
		ActivityDto activityDto = new ActivityDto();

		if (activityIdx > 0) {
			activityDto.setIdx(activityIdx);
			activityDto.setActivityDelFlg(true);
			if (memberId != null && !memberId.isEmpty()) {
				activityDto.setUpdater(memberId);
			}

			int activityResultCount = apiActivityDao.updateTblActivityByIdx(activityDto);

			if (activityResultCount > 0) {
				//TBL_ACTIVITY 갱신 : TRUE
				tblActivityResultFlg = true;
				
				tblMediaResultFlg = verifyUtil.verifyDropMedia(activityIdx,memberId);
				
				apiActivityFoodDao.deleteTblActivityFoodByIdx(activityIdx);
			}
		}
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (tblActivityResultFlg == true && tblMediaResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동이 정상적으로 삭제되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 삭제에 실패했습니다.");
		}

		return apiResult;
	}

	@ApiOperation(value = "UPDATE TBL_ACTIVITY ACTIVITY_HIDDEN_FLG", notes = "UPDATE TBL_ACTIVITY ACTIVITY_HIDDEN_FLG")
	@PostMapping(value = "/activity/modify/hidden")
	public Map<String, String> updateTblActivityHiddenFlg(
		@RequestParam String memberId,				//TBL_MEMBER.id
		@RequestParam int activityIdx,				//TBL_ACTIVITY.idx
		@RequestParam Boolean activityHiddenFlg,	//TBL_ACTIVITY.activity_hidden_flg
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		//TBL_ACTIVITY 갱신 확인용 플래그
		Boolean tblActivityResultFlg = false;
		
		//TBL_ACTIVITY 갱신 처리
		ActivityDto activityDto = new ActivityDto();
		
		String activityHiddenImg = "";
		if (activityIdx > 0) {
			activityDto.setIdx(activityIdx);
			activityDto.setActivityHiddenFlg(activityHiddenFlg);
			if (memberId != null && !memberId.isEmpty()) {
				activityDto.setUpdater(memberId);
			}

			int activityResultCount = apiActivityDao.updateTblActivityByIdx(activityDto);
			
			if (activityResultCount > 0) {
				//TBL_ACTIVITY 갱신 : TRUE
				tblActivityResultFlg = true;
				
				activityHiddenImg = apiActivityDao.selectTblActivityHiddenInfoByActivityIdx(activityIdx);
			}
		}

		Map<String, String> apiResult = new HashMap<>();
		
		if (tblActivityResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("activityHiddenImg",activityHiddenImg);
			apiResult.put("message", "활동 표시여부가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 표시여부 변경에 실패했습니다.");
		}

		return apiResult;
	}

	@ApiOperation(value = "UPDATE TBL_ACTIVITY LIKE", notes = "UPDATE TBL_ACTIVITY LIKE_DISLIKE")
	@PostMapping(value = "/activity/modify/like")
	public Map<String, String> updateTblActivityLikeNum(
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam Boolean likeFlg,		//TBL_ACTIVITY_SCORE 갱신용 플래그
		@RequestParam int activityIdx,		//TBL_ACTIVITY.idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = 0;
		if (memberId != null && !memberId.isEmpty()) {
			memberIdx = memberUtil.getMemberIdx(memberId);
		}

		Map<String, String> utilResultMap = new HashMap<String, String>();
		if (memberIdx > 0 && activityIdx > 0) {
			utilResultMap = verifyUtil.verifyLikeNum(memberId, likeFlg, activityIdx);
		}
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (utilResultMap.get("result") == "200") {
			apiResult.put("result", "200");
			apiResult.put("activityIdx", String.valueOf(activityIdx));
			apiResult.put("likeNum", utilResultMap.get("likeNum"));
			apiResult.put("likeImg", utilResultMap.get("likeImg"));
			apiResult.put("message", "활동의 좋아요가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동의 좋아요 변경에 실패했습니다.");
		}

		return apiResult;
	}
	
	@ApiOperation(value = "SELECT TBL_ACTIVITY LIST", notes = "SELECT TBL_ACTIVITY LIST")
	@GetMapping(value = "/activity/select/list")
	public JSONArray selectTblActivityList(
		@RequestParam int productIdx,
		@RequestParam Boolean selectMemberFlg,
		@RequestParam Boolean orderFlg,
		@RequestParam String productType,
		@RequestParam String dateParam,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {

	
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");

		ActivityParamDto paramDto = new ActivityParamDto();
		if (dateParam != null && !dateParam.isEmpty()) {
			paramDto.setDateParam(dateParam);
		} else {
			paramDto.setDateParam(null);
		}
		
		if (dateParam != null && !dateParam.isEmpty()) {
			paramDto.setProductType(productType);
		} else {
			paramDto.setProductType(null);
		}
		
		//월간/일간 여부 판단 후 플레그값 설정
		int dateStrLevel = dateParam.split("-").length;
		if(dateStrLevel == 2) {
			paramDto.setMonthFlg(true);
		}
		else if(dateStrLevel == 3) {
			paramDto.setMonthFlg(false);
		}
		
		paramDto.setMemberIdx(memberIdx);
		paramDto.setProductIdx(productIdx);
		paramDto.setSelectMemberFlg(selectMemberFlg);
		paramDto.setOrderFlg(orderFlg);
		
		List<ActivityDto> activityDtoList = apiActivityDao.selectTblActivityList(paramDto);
		
		JSONArray jsonArr = new JSONArray();
		if (activityDtoList.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
	    	
			for (int i=0; i<activityDtoList.size(); i++) {
	    		int activityIdx = activityDtoList.get(i).getIdx();
	    		
	    		List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectTblFoodInfoListByActivityIdx(activityIdx);
	    		String foodName = "-";
	    		int foodLength = foodInfoDtoList.size();
	    		if (foodLength > 0) {
	    			if (foodLength == 1) {
	    				foodName = foodInfoDtoList.get(0).getFoodName();
	    			} else if (foodLength > 1) {
	    				foodName = foodInfoDtoList.get(0).getFoodName() + " 외 " + (foodLength - 1) + "개";
	    			}
	    		}
	    		
				List<NotificationDto> notificationDtoList = apiNotificationDao.selectTblNotificationListByActivityIdx(activityIdx);
				
				ConvertDtoToJson<ActivityDto> convertActivityDto = new ConvertDtoToJson<ActivityDto>(activityDtoList.get(i));
				ConvertDtoListToJson<NotificationDto> convertNotificationDtoList = new ConvertDtoListToJson<NotificationDto>(notificationDtoList);
				
				JSONObject jsonObj = new JSONObject();
				
				JSONObject jsonActivity = convertActivityDto.convertDtoToJson();
				jsonActivity.put("foodName", foodName);
				JSONArray jsonNotificationList = convertNotificationDtoList.convertDtoListToJson();
				
				jsonObj.put("activity",jsonActivity);
				jsonObj.put("notificationList", jsonNotificationList);
				
				jsonArr.add(jsonObj);
	    	}
		}

		return jsonArr;
	}
	
	@ApiOperation(value = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX", notes = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX")
	@GetMapping(value = "/activity/product/recent")
	public List<ProductDto> selectRecentActivityProductByMemberIdx(
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		List<ProductDto> productDtoList = apiActivityProductDao.selectRecentActivityProductByMemberIdx(memberIdx);
		
		return productDtoList;
	}
	
	@ApiOperation(value = "ACTIVITY ADDRESS REGIST", notes = "ACTIVITY ADDRESS REGIST")
	@PostMapping(value = "/activity/addr/regist")
	public Map<String, Object>insertTblActivityAddr (
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam String addrName,		//TBL_ACTIVITY_ADDR.addr_name
		@RequestParam String roadAddr,		//TBL_ACTIVITY_ADDR.road_addr
		@RequestParam String jibunAddr,		//TBL_ACTIVITY_ADDR.jibun_addr
		@RequestParam String detailAddr,	//TBL_ACTIVITY_ADDR.detail_addr
		@RequestParam String latitude,		//TBL_ACTIVITY_ADDR.latitude
		@RequestParam String longitude,		//TBL_ACTIVITY_ADDR.longitude
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ActivityAddrDto activityAddrDto = new ActivityAddrDto();
		activityAddrDto.setAddrName(addrName);
		activityAddrDto.setRoadAddr(roadAddr);
		activityAddrDto.setJibunAddr(jibunAddr);
		activityAddrDto.setLatitude(latitude);
		activityAddrDto.setLongitude(longitude);
		activityAddrDto.setCreater(memberId);
		activityAddrDto.setUpdater(memberId);
		
		if(detailAddr != null && !detailAddr.isEmpty()) {
			activityAddrDto.setDetailAddr(detailAddr);
		}
		
		int activityAddrIdx = apiActivityAddrDao.insertTblActivityAddr(activityAddrDto);
		
		int activityAddrLogIdx = -1;
		if(activityAddrIdx > 0) {
			ActivityAddrLogDto activityAddrLogDto = new ActivityAddrLogDto();
			activityAddrLogDto.setMemberIdx(memberIdx);
			activityAddrLogDto.setLogAddrIdx(activityAddrIdx);
			activityAddrLogDto.setLogAddrName(addrName);
			activityAddrLogDto.setCreater(memberId);
			activityAddrLogDto.setUpdater(memberId);
			
			activityAddrLogIdx = apiTblLogDao.insertTblActivityAddrLog(activityAddrLogDto);
			if (activityAddrLogIdx > 0) {
				activityAddrDto.setIdx(activityAddrIdx);
			}
		}
		
		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		if(activityAddrLogIdx > 0) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동 주소 등록에 성공했습니다.");
			apiResult.put("activityAddrDto", activityAddrDto);
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "활동 주소 등록에 실패했습니다.");
		}
		
		return apiResult;
	}
	
	@ApiOperation(value = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX", notes = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX")
	@GetMapping(value = "/activity/addr/recent")
	public List<ActivityAddrDto> selectRecentActivityAddrByMemberIdx(
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		List<ActivityAddrDto> activityAddrDtoList = apiActivityAddrDao.selectRecentActivityAddrByMemberIdx(memberIdx);
		
		return activityAddrDtoList;
	}
	
	@ApiOperation(value = "ACTIVITY FOOD REGIST", notes = "ACTIVITY FOOD REGIST")
	@PostMapping(value = "/activity/food/regist")
	public Map<String, Object>insertTblFoodInfo (
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam String foodName,		//TBL_ACTIVITY_FOOD.food_name
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		Boolean tblFoodInfoResultFlg = false;
		Boolean tblActivityFoodLogResultFlg = false;
		
		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		int foodCnt = -1;
		FoodInfoDto foodInfoDto = new FoodInfoDto();
		if (foodName != null && !foodName.isEmpty()) {
			foodCnt = apiActivityFoodDao.selectTblFoodInfoCntByFoodName(foodName);
			
			if (foodCnt > 0) {
				apiResult.put("result", "-1");
				apiResult.put("message", "중복된 이름의 음식이  이미 존재합니다.");
			} else {
				foodInfoDto.setFoodName(foodName);
				foodInfoDto.setCreater(memberId);
				foodInfoDto.setUpdater(memberId);
				
				int foodInfoIdx = apiActivityFoodDao.insertTblFoodInfo(foodInfoDto);
				
				int activityFoodLogIdx = -1;
				if(foodInfoIdx > 0) {
					tblFoodInfoResultFlg = true;
					
					ActivityFoodLogDto activityFoodLogDto = new ActivityFoodLogDto();
					activityFoodLogDto.setMemberIdx(memberIdx);
					activityFoodLogDto.setLogFoodIdx(foodInfoIdx);
					activityFoodLogDto.setLogFoodName(foodName);
					activityFoodLogDto.setCreater(memberId);
					activityFoodLogDto.setUpdater(memberId);
					
					activityFoodLogIdx = apiTblLogDao.insertTblActivityFoodLog(activityFoodLogDto);
					if (activityFoodLogIdx > 0) {
						tblActivityFoodLogResultFlg = true;
						
						foodInfoDto.setIdx(foodInfoIdx);
					}
				}
			}
		}
		
		if(tblFoodInfoResultFlg == true && tblActivityFoodLogResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "활동 음식 등록에 성공했습니다.");
			apiResult.put("foodInfoDto", foodInfoDto);
		} else {
			if (apiResult == null || apiResult.isEmpty()) {
				apiResult.put("result", "-1");
				apiResult.put("message", "활동 음식 등록에 실패했습니다.");
			}
		}
		
		return apiResult;
	}
	
	@ApiOperation(value = "SELECT FOOD INFO BY FOOD IDX", notes = "SELECT FOOD BY FOOD IDX")
	@GetMapping(value = "/activity/food/list")
	public List<FoodInfoDto> selectTblFoodInfoByIdx(
		@RequestParam String foodInfoIdxList,	//TBL_ACTIVITY_FOOD.food_name
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		List<Integer> idxList = new ArrayList<Integer>();
		if (foodInfoIdxList != null && !foodInfoIdxList.isEmpty()) {
			idxList = convertUtil.convertStringToIntegerList(foodInfoIdxList);
		}
		
		List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectTblFoodInfoListByIdx(idxList);
		
		return foodInfoDtoList;
	}
	
	@ApiOperation(value = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX", notes = "SELECT RECENT ACTIVITY ADDR BY MEMBER IDX")
	@GetMapping(value = "/activity/food/recent")
	public List<FoodInfoDto> selectRecentActivityFoodByMemberIdx(
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectRecentActivityFoodByMemberIdx(memberIdx);
		
		return foodInfoDtoList;
	}
	
	@ApiOperation(value = "GET ACTIVITY LIST BY MONTH", notes = "GET ACTIVITY LIST BY MONTH")
	@GetMapping(value = "/activity/calendar/month")
	public List<CalendarDto> getActivityListByMonth(
		@RequestParam String memberId,
		@RequestParam String monthParam,
		@RequestParam String productType,
		HttpServletRequest request,
		HttpServletResponse response	
	) throws NumberFormatException, Exception {
		Integer memberIdx = memberUtil.getMemberIdx(memberId);
		List<CalendarDto> calendarList = new ArrayList<CalendarDto>();
		
		if(monthParam != null) {
			if(productType != null) {
				monthParam += "-01";
				Map<String, Object> paramList = new HashMap<String, Object>();
				paramList.put("memberIdx", memberIdx);
				paramList.put("monthParam", monthParam);
				paramList.put("productType", productType);

				List<ActivityDto> resultList = apiActivityDao.selectTblActivityByMonth(paramList);

				String date[] = monthParam.split("-");
				if (date.length == 3) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

					String year = date[0];
					String month = date[1];

					//해당월 마지막일 구하기
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);	
					int lastMonthDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
					
					
					for (int i = 1; i <= lastMonthDay; i++) {
						if (i == 1) {
							cal.set(Calendar.DAY_OF_MONTH, 1);
						} else {
							cal.add(Calendar.DAY_OF_MONTH, 1);
						}
						String calendarDate = sdf.format(cal.getTime()).toString();

						boolean calendarFlg = false;

						CalendarDto calendarDto = new CalendarDto();
						calendarDto.setProductType(productType);
						calendarDto.setDate(calendarDate);

						for (int j = 0; j < resultList.size(); j++) {
							String activityDate = sdf.format(resultList.get(j).getCreateDate()).toString();
							if (calendarDate.equals(activityDate)) {
								calendarFlg = true;
							}
						}
						calendarDto.setActivityFlg(calendarFlg);

						calendarList.add(calendarDto);
					}

				}
			}
		}
		return calendarList;
	}
}