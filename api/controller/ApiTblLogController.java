package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiTblLogDao;
import com.bvdev.alcoholproject.api.dto.ActivityAddrLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityFoodLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityProductLogDto;
import com.bvdev.alcoholproject.api.dto.NotificationLogDto;
import com.bvdev.alcoholproject.common.util.MemberUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiTblLogController {
	@Inject
	private ApiTblLogDao apiTblLogDao;
	
	@Inject
	private MemberUtil memberUtil;
	
	@ApiOperation(value = "UPDATE TBL_ACTIVITY_PRODUCT_LOG LOG_DEL_FLG", notes = "UPDATE TBL_ACTIVITY_PRODUCT_LOG LOG_DEL_FLG")
	@PostMapping(value = "/activityProduct/log")
	public Map<String, String> updateTblActivityProductLog(
		@RequestParam String memberId,			//TBL_MEMBER.id
		@RequestParam int logProductIdx,		//TBL_ACTIVITY_ADDR_LOG.log_addr_idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ActivityProductLogDto paramDto = new ActivityProductLogDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setLogProductIdx(logProductIdx);
		paramDto.setUpdater(memberId);

		int logResult = apiTblLogDao.deleteTblActivityProductLog(paramDto);
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (logResult > 0) {
			apiResult.put("result", "200");
			apiResult.put("message", "최근 등록한 활동 상품이 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "최근 등록한 활동 상품의 갱신에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "UPDATE TBL_ACTIVITY_ADDR_LOG LOG_DEL_FLG", notes = "UPDATE TBL_ACTIVITY_ADDR_LOG LOG_DEL_FLG")
	@PostMapping(value = "/activityAddr/log")
	public Map<String, String> updateTblActivityAddrLog(
		@RequestParam String memberId,			//TBL_MEMBER.id
		@RequestParam int logAddrIdx,			//TBL_ACTIVITY_ADDR_LOG.log_addr_idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ActivityAddrLogDto paramDto = new ActivityAddrLogDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setLogAddrIdx(logAddrIdx);
		paramDto.setUpdater(memberId);

		int logResult = apiTblLogDao.deleteTblActivityAddrLog(paramDto);
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (logResult > 0) {
			apiResult.put("result", "200");
			apiResult.put("message", "최근 등록한 활동 주소가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "최근 등록한 활동 주소의 갱신에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "UPDATE TBL_ACTIVITY_FOOD_LOG LOG_DEL_FLG", notes = "UPDATE TBL_ACTIVITY_FOOD_LOG LOG_DEL_FLG")
	@PostMapping(value = "/activityFood/log")
	public Map<String, String> updateTblActivityFoodLog(
		@RequestParam String memberId,			//TBL_MEMBER.id
		@RequestParam int logFoodIdx,			//TBL_ACTIVITY_ADDR_LOG.log_addr_idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ActivityFoodLogDto paramDto = new ActivityFoodLogDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setLogFoodIdx(logFoodIdx);
		paramDto.setUpdater(memberId);

		int logResult = apiTblLogDao.deleteTblActivityFoodLog(paramDto);
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (logResult > 0) {
			apiResult.put("result", "200");
			apiResult.put("message", "최근 등록한 활동 주소가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "최근 등록한 활동 주소의 갱신에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "UPDATE TBL_NOTIFICACTION_LOG LOG_DEL_FLG", notes = "UPDATE TBL_NOTIFICATION_LOG LOG_DEL_FLG")
	@PostMapping(value = "/notification/log")
	public Map<String, String> updateTblNotificationLog(
		@RequestParam String memberId,			//TBL_MEMBER.id
		@RequestParam String logMemberId,		//TBL_NOTIFICATION_LOG.log_member_idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = memberUtil.getMemberIdx(memberId);
		int logMemberIdx = memberUtil.getMemberIdx(logMemberId);
		
		NotificationLogDto paramDto = new NotificationLogDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setLogMemberIdx(logMemberIdx);
		paramDto.setUpdater(memberId);

		int logResult = apiTblLogDao.deleteTblNotificationLogByMemberIdx(paramDto);
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (logResult > 0) {
			apiResult.put("result", "200");
			apiResult.put("message", "최근 등록한 멤버가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "최근 등록한 멤버의 갱신에 실패했습니다.");
		}
		return apiResult;
	}
}