package com.bvdev.alcoholproject.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiAutoCompleteDao;
import com.bvdev.alcoholproject.api.dto.AddrAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.ApiAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.FoodAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.MemberAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.ProductAutoCompleteDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiAutoCompleteController {
	@Inject
	private ApiAutoCompleteDao apiAutoCompleteDao;

	@ApiOperation(value = "SELECT ACTIVITY PRODUCT TO AUTO_COMPLATE", notes = "SELECT ACTIVITY PRODUCT TO AUTO_COMPLATE")
	@ApiImplicitParam(name = "param", value = "자동완성 검색")
	@GetMapping(value = "/product/autocomplete")
	public ApiAutoCompleteDto productAutoCompleteApi(
		@RequestParam String keyword,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		List<ProductAutoCompleteDto> productData = apiAutoCompleteDao.selectTblProductByAutoComplete(keyword);
		
		ApiAutoCompleteDto apiAutoCompleteDto = new ApiAutoCompleteDto();
		apiAutoCompleteDto.setSuccess(true);
		apiAutoCompleteDto.setProductData(productData);
		
		return apiAutoCompleteDto;
	}
	
	@ApiOperation(value = "SELECT ACTIVITY ADDR TO AUTO_COMPLATE", notes = "SELECT ACTIVITY ADDR TO AUTO_COMPLATE")
	@ApiImplicitParam(name = "param", value = "자동완성 검색")
	@GetMapping(value = "/addr/autocomplete")
	public ApiAutoCompleteDto addrAutoCompleteApi(
		@RequestParam String keyword,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		List<AddrAutoCompleteDto> addrData = apiAutoCompleteDao.selectTblActivityAddrByAutoComplete(keyword);
		
		ApiAutoCompleteDto apiAutoCompleteDto = new ApiAutoCompleteDto();
		apiAutoCompleteDto.setSuccess(true);
		apiAutoCompleteDto.setAddrData(addrData);
		
		return apiAutoCompleteDto;
	}

	@ApiOperation(value = "SELECT ACTIVITY FOOD TO AUTO_COMPLATE", notes = "SELECT ACTIVITY FOOD TO AUTO_COMPLATE")
	@ApiImplicitParam(name = "param", value = "자동완성 검색")
	@GetMapping(value = "/food/autocomplete")
	public ApiAutoCompleteDto foodAutoCompleteApi(
		@RequestParam String keyword,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		String tempKeyword = null;
		
		Boolean korKeywordHeadFlg = false;
		Boolean korKeywordTailFlg = false;
		
		if (keyword.length() == 1) {
			korKeywordHeadFlg = true;
			tempKeyword = keyword.substring(0);
		} else {
			tempKeyword = keyword.substring(keyword.length()-1);
		}
			
		String korKeywordHead = null;
		String korKeywordTail = null;
		
		switch (tempKeyword) {
			case "ㄱ":
				korKeywordHead = "가";
				korKeywordTail = "나";
				break;
			case "ㄴ":
				korKeywordHead = "나";
				korKeywordTail = "다";
				break;
			case "ㄷ":
				korKeywordHead = "다";
				korKeywordTail = "라";
				break;
			case "ㄹ":
				korKeywordHead = "라";
				korKeywordTail = "마";
				break;
			case "ㅁ":
				korKeywordHead = "마";
				korKeywordTail = "바";
				break;
			case "ㅂ":
				korKeywordHead = "바";
				korKeywordTail = "사";
				break;
			case "ㅅ":
				korKeywordHead = "사";
				korKeywordTail = "아";
				break;
			case "ㅇ":
				korKeywordHead = "아";
				korKeywordTail = "자";
				break;
			case "ㅈ":
				korKeywordHead = "자";
				korKeywordTail = "차";
				break;
			case "ㅊ":
				korKeywordHead = "차";
				korKeywordTail = "카";
				break;
			case "ㅋ":
				korKeywordHead = "카";
				korKeywordTail = "타";
				break;
			case "ㅌ":
				korKeywordHead = "타";
				korKeywordTail = "파";
				break;
			case "ㅍ":
				korKeywordHead = "파";
				korKeywordTail = "하";
				break;
			case "ㅎ":
				korKeywordHead = "하";
				break;
		}
		
		if (korKeywordHeadFlg == false && korKeywordHead != null) {
			korKeywordTailFlg = true;
		}
		
		FoodAutoCompleteDto paramDto = new FoodAutoCompleteDto();
		if (korKeywordTailFlg == true && korKeywordHead != null) {
			keyword = keyword.substring(0, keyword.length()-1);
		}
		paramDto.setKeyword(keyword);
		paramDto.setKorKeywordHead(korKeywordHead);
		paramDto.setKorKeywordTail(korKeywordTail);
		paramDto.setKorKeywordHeadFlg(korKeywordHeadFlg);
		paramDto.setKorKeywordTailFlg(korKeywordTailFlg);
		
		List<FoodInfoDto> foodData = apiAutoCompleteDao.selectTblFoodInfoByAutoComplete(paramDto);
		
		ApiAutoCompleteDto apiAutoCompleteDto = new ApiAutoCompleteDto();
		apiAutoCompleteDto.setSuccess(true);
		apiAutoCompleteDto.setFoodData(foodData);
		
		return apiAutoCompleteDto;
	}
	
	@ApiOperation(value = "SELECT MEMBER TO AUTO_COMPLATE", notes = "SELECT MEMBER TO AUTO_COMPLATE")
	@ApiImplicitParam(name = "param", value = "자동완성 검색")
	@GetMapping(value = "/member/autocomplete")
	public ApiAutoCompleteDto memberAutoCompleteApi(
		@RequestParam String param,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		MemberAutoCompleteDto paramDto = new MemberAutoCompleteDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setKeyword(param);
		
		List<MemberAutoCompleteDto> memberData = apiAutoCompleteDao.selectTblMemberByAutoComplete(paramDto);
		
		ApiAutoCompleteDto apiAutoCompleteDto = new ApiAutoCompleteDto();
		apiAutoCompleteDto.setSuccess(true);
		apiAutoCompleteDto.setMemberData(memberData);
		
		return apiAutoCompleteDto;
	}
}