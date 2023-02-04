package com.bvdev.alcoholproject.front.product.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bvdev.alcoholproject.common.util.MemberUtil;
import com.bvdev.alcoholproject.front.product.service.ProductService;
import com.bvdev.alcoholproject.front.product.vo.ProductFormVo;
import com.bvdev.alcoholproject.front.product.vo.SearchFormVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	@Inject
	MemberUtil memberUtil;
	
	@Inject
	ProductService productService;

	@RequestMapping(value = "front/product/form", method = RequestMethod.GET)
    public ModelAndView productDescriptions(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		int memberIdx = memberUtil.getMemberIdx(memberId);
		
		int productIdx = -1;
		if (request.getParameter("productIdx") != null && !request.getParameter("productIdx").isEmpty()) {
			productIdx = Integer.parseInt(request.getParameter("productIdx"));
			
			ProductFormVo productFormVo = productService.productFormVo(memberIdx, productIdx);
			productFormVo.setMemberId(memberId);
			productFormVo.setProductIdx(productIdx);
			
			mav.addObject("productFormVo",productFormVo);
		}
    	
		mav.setViewName("front/product/productForm");
		
		return mav;
    }
	
	@RequestMapping(value = "front/product/list", method = RequestMethod.GET)
	public ModelAndView productDetailFeed(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		String memberId = (String)session.getAttribute("id");
		mav.addObject("memberId",memberId);
		
		if (request.getParameter("productIdx") != null && !request.getParameter("productIdx").isEmpty()) {
			mav.addObject("productIdx",Integer.parseInt(request.getParameter("productIdx")));
		}
		
		if (request.getParameter("productNameKor") != null && !request.getParameter("productNameKor").isEmpty()) {
			mav.addObject("productNameKor",request.getParameter("productNameKor"));
		}
		
		if (request.getParameter("activityNum") != null && !request.getParameter("activityNum").isEmpty()) {
			mav.addObject("activityNum",Integer.parseInt(request.getParameter("activityNum")));
		}
		
		mav.setViewName("front/product/listForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/front/product/review", method = RequestMethod.GET)
    public ModelAndView reviewForm(
    	HttpServletRequest request,
    	HttpServletResponse response
    ) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("id");
		mav.addObject("memberId",memberId);
		
		if (request.getParameter("productIdx") != null && !request.getParameter("productIdx").isEmpty()) {
			String productIdx = request.getParameter("productIdx");
			mav.addObject("productIdx", productIdx);
		}
		
		mav.setViewName("front/product/reviewForm");
		
		return mav;
    }
	
	@RequestMapping(value = "/front/product/search", method = RequestMethod.GET)
    public ModelAndView searchForm(
    	HttpServletRequest request,
    	HttpServletResponse response
    ) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String productType = null;
		if (request.getParameter("productType") != null && !request.getParameter("productType").isEmpty()) {
			productType = request.getParameter("productType");
		}
		
		SearchFormVo searchFormVo = productService.searchFormVo(productType);
		
		mav.addObject("searchFormVo",searchFormVo);
		
		mav.setViewName("front/product/searchForm");
		
		return mav;
    }
}