package com.bvdev.alcoholproject.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiActivityAddrDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityFoodDao;
import com.bvdev.alcoholproject.api.dao.ApiActivityProductDao;
import com.bvdev.alcoholproject.api.dao.ApiMediaDao;
import com.bvdev.alcoholproject.api.dao.ApiMemberDao;
import com.bvdev.alcoholproject.api.dao.ApiNotificationDao;
import com.bvdev.alcoholproject.api.dao.ApiTblLogDao;
import com.bvdev.alcoholproject.api.dto.ActivityAddrDto;
import com.bvdev.alcoholproject.api.dto.ActivityAddrLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityFoodDto;
import com.bvdev.alcoholproject.api.dto.ActivityFoodLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityParamDto;
import com.bvdev.alcoholproject.api.dto.ActivityProductLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityScoreDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.MediaDto;
import com.bvdev.alcoholproject.api.dto.NotificationDto;
import com.bvdev.alcoholproject.api.dto.NotificationLogDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;

@Service
public class VerifyUtil {
	@Inject
	private ApiMemberDao apiMemberDao;

	@Inject
	private ApiActivityDao apiActivityDao;
	
	@Inject
	private ApiActivityProductDao apiActivityProductDao;
	
	@Inject
	private ApiActivityAddrDao apiActivityAddrDao;
	
	@Inject
	private ApiActivityFoodDao apiActivityFoodDao;
	
	@Inject
	private ApiMediaDao apiMediaDao;
	
	@Inject
	private ApiNotificationDao apiNotificationDao;
	
	@Inject
	private ApiTblLogDao apiTblLogDao; 
	
	@Inject
	private MemberUtil memberUtil;
	
	@Inject
	private ConvertUtil convertUtil;
	
	public Map<String, String> verifyLikeNum(String memberId, Boolean likeFlg, int activityIdx) throws Exception {
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		Map<String, String> utilResultMap = new HashMap<String, String>();

		//TBL_ACTIVITY_SCORE 갱신 처리
		ActivityScoreDto activityScoreDto = new ActivityScoreDto();
		activityScoreDto.setMemberIdx(memberIdx);
		activityScoreDto.setActivityIdx(activityIdx);
		activityScoreDto.setCreater(memberId);
		activityScoreDto.setUpdater(memberId);
		
		String likeImg = "";
		int resultCnt = 0;
		if (likeFlg == true) {
			resultCnt = apiActivityDao.deleteTblActivityScore(activityScoreDto);
			likeImg = "/alcoholProject/images/common/empty_heart.svg";
		} else {
			resultCnt = apiActivityDao.insertTblActivityScore(activityScoreDto);
			likeImg = "/alcoholProject/images/common/full_heart.svg";
		}	
		
		//TBL_ACTIVITY 갱신 처리
		if (resultCnt > 0) {
			ActivityParamDto activityParamDto = new ActivityParamDto();
			activityParamDto.setActivityIdx(activityIdx);
			activityParamDto.setLikeFlg(likeFlg);
			
			int activityResultCnt = apiActivityDao.updateTblActivityLikeNumByIdx(activityParamDto);
			int likeNum = apiActivityDao.selectTblActivityLikeNumByIdx(activityIdx);
			
			if (activityResultCnt > 0) {
				utilResultMap.put("result","200");
				utilResultMap.put("likeNum",String.valueOf(likeNum));
				utilResultMap.put("likeImg",likeImg);
			}
		}
		
		if (utilResultMap == null || utilResultMap.isEmpty()) {
			utilResultMap.put("result","-1");
		}
		
		return utilResultMap;
	}
	
	public boolean verifyRegistMedia(String memberId, int activityIdx, String strOriginMediaFilename) throws Exception {
		Boolean tblMediaResultFlg = false;
		
		String filenameArr[] = null;
		filenameArr = strOriginMediaFilename.split(",");
		
		int mediaResultCount = 0;
		for (int i=0; i<filenameArr.length; i++) {
			MediaDto mediaDto = new MediaDto();
			mediaDto.setActivityIdx(activityIdx);
			mediaDto.setOriginMediaFilename(filenameArr[i]);
			mediaDto.setUpdater(memberId);
			
			int mediaIdx = apiMediaDao.updateTblMedia(mediaDto);
			
			if (mediaIdx > 0) {
				mediaResultCount++;
			}
		}
		
		if (mediaResultCount > 0) {
			//TBL_MEDIA 갱신 : TRUE
			tblMediaResultFlg = true;
		}
		
		return tblMediaResultFlg;
	}
	
	public Boolean verifyDropMedia(int activityIdx, String memberId) throws Exception {
		Boolean tblMediaResultFlg = false;
		
		MediaDto mediaDto = new MediaDto();
		mediaDto.setActivityIdx(activityIdx);
		mediaDto.setMediaDeleteFlg(true);
		mediaDto.setUpdater(memberId);
		
		int mediaResultCount = apiMediaDao.deleteTblMediaByActivityIdx(mediaDto);
		
		if (mediaResultCount > 0) {
			tblMediaResultFlg = true;
		}
		
		return tblMediaResultFlg;
	}
	
	public Boolean verifyActivityProduct(String memberId, int productIdx) throws Exception {
		Boolean tblProductResultFlg = false;
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		if (productIdx > 0) {
			ProductDto productDto = apiActivityProductDao.selectActivityProductByIdx(productIdx);
			
			if (productDto != null) {
				ActivityProductLogDto paramDto = new ActivityProductLogDto();
				paramDto.setMemberIdx(memberIdx);
				paramDto.setLogProductIdx(productIdx);
				paramDto.setLogProductName(productDto.getProductNameKor());
				paramDto.setCreater(memberId);
				paramDto.setUpdater(memberId);
				
				int logResult = apiTblLogDao.insertTblActivityProductLog(paramDto);
				
				if (logResult > 0) {
					tblProductResultFlg = true;
				}
			}
		} else {
			tblProductResultFlg = true;			
		}
		
		return tblProductResultFlg;
	}
	
	public Boolean verifyActivityAddr(String memberId, int activityAddrIdx) throws Exception {
		Boolean tblActivityAddrResultFlg = false;
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ActivityAddrDto activityAddrDto = apiActivityAddrDao.selectTblActivityAddrByIdx(activityAddrIdx);
		
		if (activityAddrDto != null) {
			ActivityAddrLogDto paramDto = new ActivityAddrLogDto();
			paramDto.setMemberIdx(memberIdx);
			paramDto.setLogAddrIdx(activityAddrIdx);
			paramDto.setLogAddrName(activityAddrDto.getAddrName());
			paramDto.setCreater(memberId);
			paramDto.setUpdater(memberId);
			
			int logResult = apiTblLogDao.insertTblActivityAddrLog(paramDto);
			
			if (logResult > 0) {
				tblActivityAddrResultFlg = true;
			}
		}
		
		return tblActivityAddrResultFlg;
	}
	
	public int verifyActivityFood(String memberId, int activityFoodIdx, String foodInfoIdxList) throws Exception {
		if (activityFoodIdx > 0) {
			apiActivityFoodDao.deleteTblActivityFoodByIdx(activityFoodIdx);
		}
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		String foodInfoIdx = convertUtil.convertStringToStrIntegerArr(foodInfoIdxList);
		
		List<Integer> idxList = convertUtil.convertStringToIntegerList(foodInfoIdxList);
			
		List<FoodInfoDto> foodInfoDtoList = apiActivityFoodDao.selectTblFoodInfoListByIdx(idxList);
		
		if (foodInfoDtoList.size() > 0) {
			int logCnt = 0;
			for (int i=0; i<foodInfoDtoList.size(); i++) {
				ActivityFoodLogDto activityFoodLogDto = new ActivityFoodLogDto();
				activityFoodLogDto.setMemberIdx(memberIdx);
				activityFoodLogDto.setLogFoodIdx(foodInfoDtoList.get(i).getIdx());
				activityFoodLogDto.setLogFoodName(foodInfoDtoList.get(i).getFoodName());
				activityFoodLogDto.setCreater(memberId);
				activityFoodLogDto.setUpdater(memberId);
				
				int logResult = apiTblLogDao.insertTblActivityFoodLog(activityFoodLogDto);
				
				if (logResult > 0) {
					logCnt++;
				}
			}
			
			if (foodInfoDtoList.size() == logCnt) {
				ActivityFoodDto activityFoodDto = new ActivityFoodDto();
				activityFoodDto.setFoodInfoIdx(foodInfoIdx);
				activityFoodDto.setActivityFoodDelFlg(false);
				activityFoodDto.setCreater(memberId);
				activityFoodDto.setUpdater(memberId);
				
				activityFoodIdx = apiActivityFoodDao.insertTblActivityFood(activityFoodDto);
			}
		}
		
		return activityFoodIdx;
	}
	
	public Boolean verifyMemberMentionId(String mentionIdList, String memberId, int activityIdx) throws Exception {
		Boolean tblNotificationResultFlg = true;
		tblNotificationResultFlg = false;
		int notificationResultCount = 0;
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		apiNotificationDao.deleteTblNotificationByActivityIdx(activityIdx);
		
		List<String> tempIdList = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("[@]+([A-Za-z0-9-_\\.@]+)\\s");
		Matcher matcher = pattern.matcher(mentionIdList);
		
		while(matcher.find()) {
			tempIdList.add(matcher.group(1).trim());
		}
		
		Set<String> tempSet = new HashSet<String>(tempIdList);
		List<String> notificationIdList = new ArrayList<String>(tempSet);
		
		for (int i=0; i<notificationIdList.size(); i++) {
			int notificationMemberIdx = apiMemberDao.selectTblMemberIdxById(notificationIdList.get(i));
			if (notificationMemberIdx > 0) {
				NotificationDto notificationDto = new NotificationDto();
				notificationDto.setMemberIdx(notificationMemberIdx);
				notificationDto.setActivityIdx(activityIdx);
				notificationDto.setCreater(memberId);
				
				int notificationIdx = apiNotificationDao.insertTblNotification(notificationDto);
				if (notificationIdx > 0) {
					notificationResultCount++;
					
					NotificationLogDto paramDto = new NotificationLogDto();
					String logMemberId = notificationIdList.get(i);
					int logMemberIdx = memberUtil.getMemberIdx(logMemberId);
					
					paramDto.setMemberIdx(memberIdx);
					paramDto.setLogMemberIdx(logMemberIdx);
					
					NotificationLogDto notificationLogDto = new NotificationLogDto();
					notificationLogDto.setMemberIdx(memberIdx);
					notificationLogDto.setLogMemberIdx(logMemberIdx);
					notificationLogDto.setLogMemberId(logMemberId);
					notificationLogDto.setCreater(memberId);
					notificationLogDto.setUpdater(memberId);
					
					apiTblLogDao.insertTblNotificationLog(notificationLogDto);
				}
			}
		}
		
		if (notificationResultCount > 0) {
			//TBL_NOTIFICATION 등록 : TRUE
			tblNotificationResultFlg = true;
		}
		return tblNotificationResultFlg;
	}
}