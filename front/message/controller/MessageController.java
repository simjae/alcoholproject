package com.bvdev.alcoholproject.front.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MessageController {
	
	@RequestMapping(value = "front/message/main", method = RequestMethod.GET)
    public ModelAndView messageForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("front/message/main");
		
		return mav;
    }
}