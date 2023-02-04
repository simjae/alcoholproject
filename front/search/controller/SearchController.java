package com.bvdev.alcoholproject.front.search.controller;

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
public class SearchController {
	
	@RequestMapping(value = "front/search/main", method = RequestMethod.GET)
    public ModelAndView mainForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("front/search/main");
		
		return mav;
    }
	
	@RequestMapping(value = "front/search/search", method = RequestMethod.GET)
    public ModelAndView searchForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("front/search/searchForm");
		
		return mav;
    }
}