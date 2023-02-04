package com.bvdev.alcoholproject.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiMemberDao;
import com.bvdev.alcoholproject.api.dto.MemberAutoCompleteDto;
import com.bvdev.alcoholproject.common.util.MemberUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")

public class ApiMemberController {
	@Inject
	private ApiMemberDao apiMemberDao;
	
	@Inject
	MemberUtil memberUtil;
	
	@ApiOperation(value = "SELECT MENTION MEMBER BY MEMBER ID", notes = "SELECT MENTION MEMBER BY MEMBER ID")
	@ApiImplicitParam(name = "memberId", value = "활동에서 등록할 멤버 ID 확인")
	@GetMapping(value = "/member/confirm")
	public List<MemberAutoCompleteDto> selectMemberInfoByMemberId(
		@RequestParam String tempMentionId,		//TBL_MEMBER.id
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		String tempMentionIdArr[] = tempMentionId.split("@");
		
		List<String> tempMentionIdList = new ArrayList<String>();
		for (int i=0; i<tempMentionIdArr.length; i++) {
			tempMentionIdList.add(tempMentionIdArr[i]);
		}
		
		MemberAutoCompleteDto paramDto = new MemberAutoCompleteDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setTempMentionIdList(tempMentionIdList);
		
		List<MemberAutoCompleteDto> memberAutoCompleteDtoList = apiMemberDao.selectMentionMemberByMemberIdList(paramDto);
		
		return memberAutoCompleteDtoList;
	}
	
	@ApiOperation(value = "SELECT RECENT MENTION MEMBER BY MEMBER ID", notes = "SELECT RECENT MENTION MEMBER BY MEMBER ID")
	@ApiImplicitParam(name = "memberId", value = "최근 활동에서 등록한 멤버 ID 조회")
	@GetMapping(value = "/activity/member/recent")
	public List<MemberAutoCompleteDto> selectRecentMentionMemberByMemberId(
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		List<MemberAutoCompleteDto> memberAutoCompleteDtoList = apiMemberDao.selectRecentMentionMemberByMemberIdx(memberIdx);
		
		return memberAutoCompleteDtoList;
	}
}