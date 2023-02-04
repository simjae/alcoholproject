package com.bvdev.alcoholproject.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.api.dto.SessionDto;
import com.bvdev.alcoholproject.common.exception.SessionException;

public class FrontSessionUtil {

	public static SessionDto getSession(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("idx") == null) {
			Exception e = new SessionException("session null");
			throw e;
		}
		
		SessionDto sessionDto = new SessionDto();
		
		sessionDto.setIdx((int)session.getAttribute("idx"));
		sessionDto.setId((String)session.getAttribute("id"));
		sessionDto.setName((String)session.getAttribute("name"));
		sessionDto.setDisplayName((String)session.getAttribute("displayName"));
		sessionDto.setEmail((String)session.getAttribute("email"));
		sessionDto.setMobile((String)session.getAttribute("mobile"));
		sessionDto.setGender((String)session.getAttribute("gender"));
		sessionDto.setBirth((String)session.getAttribute("birth"));
		sessionDto.setRegIp((String)session.getAttribute("regIp"));
		sessionDto.setLoginIp((String)session.getAttribute("loginIp"));
		sessionDto.setMemberLevel((int)session.getAttribute("memberLevel"));
		sessionDto.setMemberExp((int)session.getAttribute("memberExp"));
		sessionDto.setToken((String)session.getAttribute("token"));
		
		request.setAttribute("session", sessionDto);
		return sessionDto;
	}
	
	public static SessionDto setSession(HttpServletRequest request, MemberDto memberDto) throws Exception{
		HttpSession session = request.getSession();
		
		session.setAttribute("idx", memberDto.getIdx());
		session.setAttribute("id", memberDto.getId());
		session.setAttribute("name", memberDto.getName());
		session.setAttribute("displayName", memberDto.getDisplayName());
		session.setAttribute("email", memberDto.getEmail());
		session.setAttribute("mobile", memberDto.getMobile());
		session.setAttribute("gender", memberDto.getGender());
		session.setAttribute("birth", memberDto.getBirth());
		session.setAttribute("regIp", memberDto.getRegIp());
		session.setAttribute("loginIp", memberDto.getLoginIp());
		session.setAttribute("memberLevel", memberDto.getMemberLevel());
		session.setAttribute("memberExp", memberDto.getMemberExp());
		session.setAttribute("token", memberDto.getToken());
		
		return getSession(request);
	}
}
