package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiProductSearchDao;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductFilterDto;
import com.bvdev.alcoholproject.api.dto.ProductSearchParamDto;
import com.bvdev.alcoholproject.common.util.ConvertUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiProductSearchController {
	@Inject
	private ApiProductSearchDao apiProductSearchDao;
	
	@Inject
	private ConvertUtil convertUtil;

	@ApiOperation(value = "SELECT PRODUCT FILTER LIST", notes = "SELECT PRODUCT FILTER LIST")
	@GetMapping(value = "/search/filter")
	public Map<String, Object> selectProductSearchFilter(
		@RequestParam String productType,
		@RequestParam int categoryIdx,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		ProductSearchParamDto paramDto = new ProductSearchParamDto();
		paramDto.setProductType(productType);
		paramDto.setCategoryIdx(categoryIdx);
		
		List<ProductFilterDto> productCategoryFilterList = apiProductSearchDao.selectProductCategoryFilterList(paramDto);
		List<ProductFilterDto> productAromaFilterList = apiProductSearchDao.selectProductAromaFilterList(paramDto);
		List<String> productCountryFilterList = apiProductSearchDao.selectProductCountryFilterList(paramDto);
		
		Map<String, Object> apiResult = new HashMap<>();
		
		if (productCategoryFilterList.size() > 0 || productAromaFilterList.size() > 0 || productCountryFilterList.size() > 0) {
			apiResult.put("result", "200");
			apiResult.put("productCategoryFilterList", productCategoryFilterList);
			apiResult.put("productAromaFilterList", productAromaFilterList);
			apiResult.put("productCountryFilterList", productCountryFilterList);
			apiResult.put("message", "상품 검색용 필터를 정상적으로 취득했습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "상품 검색용 필터 취득에 실패했습니다.");
		}
		
		return apiResult;
	}
	
	@ApiOperation(value = "SELECT PRODUCT FILTER LIST", notes = "SELECT PRODUCT FILTER LIST")
	@GetMapping(value = "/search/product")
	public Map<String, Object> selectProductSearch(
		@RequestParam String productType,
		@RequestParam int categoryIdx,
		@RequestParam String aromaCategoryIdx,
		@RequestParam int minPrice,
		@RequestParam int maxPrice,
		@RequestParam String country,
		@RequestParam Boolean activityFlg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		ProductSearchParamDto paramDto = new ProductSearchParamDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setProductType(productType);
		paramDto.setCategoryIdx(categoryIdx);
		if (aromaCategoryIdx != null && !aromaCategoryIdx.isEmpty()) {
			aromaCategoryIdx = convertUtil.convertStringToStrIntegerArr(aromaCategoryIdx);
			paramDto.setAromaCategoryIdx(aromaCategoryIdx);
		}
		paramDto.setMinPrice(minPrice);
		paramDto.setMaxPrice(maxPrice);
		if (country != null && !country.isEmpty()) {
			List<String> countryList = convertUtil.convertStringToStringList(country);
			paramDto.setCountryList(countryList);
		}
		paramDto.setActivityFlg(activityFlg);
		
		List<ProductDto> productDtoList = apiProductSearchDao.selectProductSearchResultList(paramDto);
		
		Map<String, Object> apiResult = new HashMap<>();
		
		if (productDtoList.size() > 0) {
			apiResult.put("result", "200");
			apiResult.put("productDtoList", productDtoList);
			apiResult.put("message", "검색 결과를 정상적으로 취득했습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "검색 결과를 취득에 실패했습니다.");
		}
		
		return apiResult;
	}
}