
package com.bvdev.alcoholproject.front.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.api.dto.LoginDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.common.util.FrontSessionUtil;
import com.bvdev.alcoholproject.front.member.service.LoginService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/front/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		return "front/login";
	}
	
	
	@RequestMapping(value = "/front/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("idx");
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("displayName");
		session.removeAttribute("email");
		session.removeAttribute("mobile");
		session.removeAttribute("gender");
		session.removeAttribute("birth");
		session.removeAttribute("regIp");
		session.removeAttribute("loginIp");
		session.removeAttribute("memberLevel");
		session.removeAttribute("memberExp");
		session.removeAttribute("token");
		
		return "front/member/login";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView excuteForm(HttpServletRequest request, Model model) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		LoginDto loginDto = new LoginDto();
		if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			loginDto.setId(request.getParameter("id"));
		}
		
		if(request.getParameter("password") != null || !request.getParameter("password").isEmpty()) {
			loginDto.setPassword(request.getParameter("password"));
		}

		MemberDto memberDto = loginService.getLogin(loginDto);
		
		if(memberDto == null) {
			mav.setViewName("redirect:/front/login");
		} else {
			FrontSessionUtil.setSession(request,memberDto);
			
			mav.setViewName("redirect:/front/main");
		}

		return mav;
	}
}