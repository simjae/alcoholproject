package com.bvdev.alcoholproject.front.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.api.dto.BadgeDto;
import com.bvdev.alcoholproject.api.dto.MypageDto;
import com.bvdev.alcoholproject.front.member.service.MemberService;
import com.bvdev.alcoholproject.front.mypage.vo.MypageVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/front/mypage/main", method = RequestMethod.GET)
    public ModelAndView myPageForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
    	int memberIdx = (int) session.getAttribute("idx");
    	  
    	MypageVo mypageVo = new MypageVo();
    	
    	MypageDto mypageDto = memberService.selectMyPageInfoByIdx(memberIdx);
    	List<BadgeDto> badgeDtoList = memberService.selectMemberBadgeList(memberIdx);
    	
    	mypageVo.setMypageDto(mypageDto);
    	mypageVo.setBadgeDtoList(badgeDtoList);
		
		mav.addObject(mypageVo);
		mav.setViewName("front/mypage/main");
		
		return mav;
	}
}