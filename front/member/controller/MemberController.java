package com.bvdev.alcoholproject.front.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.front.activity.service.ActivityService;
import com.bvdev.alcoholproject.front.member.service.MemberService;
import com.bvdev.alcoholproject.front.member.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/front/member/insertForm", method = RequestMethod.GET)
    public ModelAndView memberInsertForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("front/member/memberInsertForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/member/updateForm", method = RequestMethod.GET)
    public ModelAndView memberUpdateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
    	int memberIdx = (int)session.getAttribute("idx");
    	
    	MemberVo memberVo = new MemberVo();
    	
    	MemberDto memberDto = memberService.selectTblMemberByIdx(memberIdx);
    	
    	memberVo.setMemberDto(memberDto);
    	
    	mav.addObject("memberVo", memberVo);
		mav.setViewName("front/member/memberUpdateForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/member/deleteForm", method = RequestMethod.GET)
    public ModelAndView memberDeleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("front/member/memberDeleteForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/member/registProc", method = RequestMethod.POST)
    public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
    	MemberDto memberDto = new MemberDto();
    	
    	String booleanStr = request.getParameter("pushYn");
    	Boolean pushYn = false;
    	if (booleanStr.isEmpty() || booleanStr == null) {
    		
    	} else {
    		Boolean.parseBoolean(booleanStr);
    	}
    	
    	memberDto.setId(request.getParameter("id"));
    	memberDto.setPassword(request.getParameter("password"));
    	memberDto.setName(request.getParameter("name"));
    	memberDto.setDisplayName(request.getParameter("displayName"));
    	memberDto.setMediaIdx(0);
    	memberDto.setEmail(request.getParameter("email"));
    	memberDto.setMobile(request.getParameter("mobile"));
    	memberDto.setGender(request.getParameter("gender"));
    	memberDto.setBirth(request.getParameter("birth"));
    	memberDto.setPushYn(pushYn);
    	
    	int memberIdx = memberService.insertTblMember(memberDto);
    	
    	if (memberIdx > 0) {
    		ActivityDto activityDto = new ActivityDto();
    		activityDto.setGroupIdx(0);
    		activityDto.setMemberIdx(memberIdx);
    		activityDto.setType("member");
    		activityDto.setAction("member_regist");
    		activityDto.setNoticeLink("-");
    		activityDto.setContent("MEMBER_REGIST");
    		activityDto.setPrimaryIdx(0);
    		activityDto.setSecondaryIdx(0);
    		activityDto.setMpttLeft(0);
    		activityDto.setMpttRight(0);
    		activityDto.setCreater(memberDto.getId());
    		activityDto.setUpdater(memberDto.getId());
    		
    		activityService.insertTblActivity(activityDto);
    	}
    	
		mav.setViewName("redirect:/front/main");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/member/modify", method = RequestMethod.POST)
    public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
    	
		HttpSession session = request.getSession();
    	int memberIdx = (int) session.getAttribute("idx");

    	MemberDto memberDto = new MemberDto();
    	memberDto.setIdx(memberIdx);
    	memberDto.setId(request.getParameter("id"));
    	memberDto.setPassword(request.getParameter("password"));
    	memberDto.setDisplayName(request.getParameter("displayName"));
    	memberDto.setMediaIdx(0);
    	memberDto.setEmail(request.getParameter("email"));
    	memberDto.setMobile(request.getParameter("mobile"));
    	
    	String booleanStr = request.getParameter("pushYn");
    	Boolean pushYn = false;
    	if (booleanStr.isEmpty() || booleanStr == null) {
    		
    	} else {
    		Boolean.parseBoolean(booleanStr);
    	}
    	
    	memberDto.setPushYn(pushYn);
    	
    	memberService.updateTblMemberByIdx(memberDto);
    	
		mav.setViewName("redirect:/front/main");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/member/withdrawal", method = RequestMethod.POST)
    public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
    	int memberIdx = (int) session.getAttribute("idx");
		
		memberService.deleteTblMemberByIdx(memberIdx);
		
		mav.setViewName("redirect:/front/main");
		
		return mav;
	}
}