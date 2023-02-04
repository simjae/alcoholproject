package com.bvdev.alcoholproject.front.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiProductDao;
import com.bvdev.alcoholproject.api.dao.ApiProductSearchDao;
import com.bvdev.alcoholproject.api.dto.ProductActivityDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductFilterDto;
import com.bvdev.alcoholproject.api.dto.ProductKeywordDto;
import com.bvdev.alcoholproject.api.dto.ProductParamDto;
import com.bvdev.alcoholproject.api.dto.ProductRecommendDto;
import com.bvdev.alcoholproject.api.dto.ProductReplyDto;
import com.bvdev.alcoholproject.api.dto.ProductSearchParamDto;
import com.bvdev.alcoholproject.api.dto.ProductShopInfoDto;
import com.bvdev.alcoholproject.front.product.vo.ProductFormVo;
import com.bvdev.alcoholproject.front.product.vo.SearchFormVo;

@Service
public class ProductService {
	
	@Inject
	private ApiProductDao apiProductDao;
	
	@Inject
	private ApiProductSearchDao apiProductSearchDao;

	public ProductFormVo productFormVo(int memberIdx, int productIdx) throws Exception {
		ProductFormVo productFormVo = new ProductFormVo();
		
		if (memberIdx > 0 && productIdx > 0) {
			ProductParamDto paramDto = new ProductParamDto();
			paramDto.setProductIdx(productIdx);
			paramDto.setMemberIdx(memberIdx);
			paramDto.setOrderFlg(false);
			
			ProductDto productDto = apiProductDao.selectTblProductByIdx(paramDto);
			if (productDto != null) {
				productFormVo.setProductDto(productDto);
			}
			
			List<ProductActivityDto> productActivityDtoList = apiProductDao.selectProductActivityList(paramDto);
			int activityNum = productActivityDtoList.size();
			productFormVo.setActivityNum(activityNum);
			productFormVo.setProductActivityDtoList(productActivityDtoList);
			
			List<ProductKeywordDto> productKeywordDtoList = apiProductDao.selectTblProductKeywordListByProductIdx(productIdx);
			productFormVo.setProductKeywordDtoList(productKeywordDtoList);
			
			List<ProductReplyDto> productContentDtoList = apiProductDao.selectProductReplyList(productIdx);
			productFormVo.setProductReplyDtoList(productContentDtoList);
			
			List<ProductShopInfoDto> productShopInfoDtoList = apiProductDao.selectProductShopInfoList(paramDto);
			productShopInfoDtoList.get(0).getSellPrice(); //34,000
			productShopInfoDtoList.get(1).getSellPrice();
			productShopInfoDtoList.get(2).getSellPrice();
			
			String[] textArr = {"firstFont","secondFont","secondFont"};
			for(int i=0; i<3; i++) {
				String sellPrice = "<p class= '" + textArr[i] + "'>" + productShopInfoDtoList.get(i).getSellPrice() + "</p>";
				productShopInfoDtoList.get(i).setSellPrice(sellPrice);
			}
			productFormVo.setProductShopInfoDtoList(productShopInfoDtoList);
			
			List<ProductRecommendDto> productRecommendDtoList = apiProductDao.selectProductRecommendList(paramDto);
			productFormVo.setProductRecommendDtoList(productRecommendDtoList);
 		}
		
		return productFormVo;
	}
	
	public SearchFormVo searchFormVo(String productType) throws Exception {
		
		SearchFormVo searchFormVo = new SearchFormVo();
		
		ProductSearchParamDto paramDto = new ProductSearchParamDto();
		paramDto.setProductType(productType);
		
		List<ProductFilterDto> productCategoryFilterList = apiProductSearchDao.selectProductCategoryFilterList(paramDto);
		List<ProductFilterDto> productAromaFilterList = apiProductSearchDao.selectProductAromaFilterList(paramDto);
		List<String> productCountryFilterList = apiProductSearchDao.selectProductCountryFilterList(paramDto);
		
		searchFormVo.setProductType(productType);
		searchFormVo.setProductCategoryFilterList(productCategoryFilterList);
		searchFormVo.setProductAromaFilterList(productAromaFilterList);
		searchFormVo.setProductCountryFilterList(productCountryFilterList);
		
		return searchFormVo;
	}
}