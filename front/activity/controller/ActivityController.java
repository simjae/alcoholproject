package com.bvdev.alcoholproject.front.activity.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.front.activity.service.ActivityService;
import com.bvdev.alcoholproject.front.activity.vo.ActivityFormVo;
import com.bvdev.alcoholproject.front.activity.vo.UpdateFormVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ActivityController {

	@Inject
	ActivityService activityService;
	
	@Inject
	MemberUtil memberUtil;
	
	@RequestMapping(value = "/front/activity/main", method = RequestMethod.GET)
    public ModelAndView mainActivityForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
    	String memberId = (String)session.getAttribute("id");
    	
    	mav.addObject("memberId",memberId);
		mav.setViewName("front/activity/main");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/activity/registForm", method = RequestMethod.GET)
    public ModelAndView insertActivityForm(
    	HttpServletRequest request,
    	HttpServletResponse response
    ) throws Exception {
    	
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		
		if (memberId != null && !memberId.isEmpty()) {
			mav.addObject("memberId",memberId);			
		}
		
		mav.addObject("memberIdx", memberId);
		mav.setViewName("front/activity/insertForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/activity/form", method = RequestMethod.GET)
    public ModelAndView selectActivityForm(
    	HttpServletRequest request,
    	HttpServletResponse response
    ) throws Exception {
    	
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		
		int activityIdx = -1;
		if (request.getParameter("activityIdx") != null && !request.getParameter("activityIdx").isEmpty()) {
			activityIdx = Integer.parseInt(request.getParameter("activityIdx"));
		}
		
		ActivityFormVo activityFormVo = activityService.activityForm(memberId, activityIdx);
		
		mav.addObject("activityFormVo",activityFormVo);
		mav.setViewName("front/activity/activityForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/activity/modifyForm", method = RequestMethod.GET)
	public ModelAndView updateActivityForm(
		HttpServletRequest request,
		HttpServletResponse response
	) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		
		int activityIdx = -1;
		if (request.getParameter("activityIdx") != null && !request.getParameter("activityIdx").isEmpty()) {
			activityIdx = Integer.parseInt(request.getParameter("activityIdx"));
		}
		
		UpdateFormVo updateFormVo = activityService.updateActivityForm(memberId, activityIdx);
		updateFormVo.setMemberId(memberId);
		
		mav.addObject("updateFormVo",updateFormVo);
		mav.setViewName("front/activity/updateForm");
		
		return mav;
	}
}