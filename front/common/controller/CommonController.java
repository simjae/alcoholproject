package com.bvdev.alcoholproject.front.common.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.front.common.service.CommonService;
import com.bvdev.alcoholproject.front.common.vo.ReplyFormVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {

	@Inject
	CommonService commonService;
	
	@Inject
	MemberUtil memberUtil;

	@RequestMapping(value = "/front/common/reply", method = RequestMethod.GET)
    public ModelAndView replyForm(
    	HttpServletRequest request,
    	HttpServletResponse response
    ) throws Exception {
    	
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		int primaryIdx = -1;
		if (request.getParameter("primaryIdx") != null && !request.getParameter("primaryIdx").isEmpty()) {
			primaryIdx = Integer.parseInt(request.getParameter("primaryIdx"));
		}
		
		int secondaryIdx = -1;
		if (request.getParameter("secondaryIdx") != null && !request.getParameter("secondaryIdx").isEmpty()) {
			secondaryIdx = Integer.parseInt(request.getParameter("secondaryIdx"));
		}
		
		int activityIdx = 0;
		if (primaryIdx > secondaryIdx) {
			activityIdx = primaryIdx;
		} else {
			activityIdx = secondaryIdx;
		}
		
		String memberId = (String)session.getAttribute("id");
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		ReplyFormVo replyFormVo = commonService.replyActivityForm(activityIdx, memberIdx, memberId);
		replyFormVo.setPrimaryIdx(primaryIdx);
		replyFormVo.setSecondaryIdx(secondaryIdx);
		replyFormVo.setMemberId(memberId);
		
		mav.addObject("replyFormVo",replyFormVo);
		mav.setViewName("front/common/replyForm");
		
		return mav;
    }
}