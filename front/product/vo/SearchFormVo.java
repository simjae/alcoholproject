package com.bvdev.alcoholproject.front.product.vo;

import java.util.List;

import com.bvdev.alcoholproject.api.dto.ProductFilterDto;

public class SearchFormVo {
	private String productType;
	private List<ProductFilterDto> productCategoryFilterList;
	private List<ProductFilterDto> productAromaFilterList;
	private List<String> productCountryFilterList;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public List<ProductFilterDto> getProductCategoryFilterList() {
		return productCategoryFilterList;
	}
	public void setProductCategoryFilterList(List<ProductFilterDto> productCategoryFilterList) {
		this.productCategoryFilterList = productCategoryFilterList;
	}
	public List<ProductFilterDto> getProductAromaFilterList() {
		return productAromaFilterList;
	}
	public void setProductAromaFilterList(List<ProductFilterDto> productAromaFilterList) {
		this.productAromaFilterList = productAromaFilterList;
	}
	public List<String> getProductCountryFilterList() {
		return productCountryFilterList;
	}
	public void setProductCountryFilterList(List<String> productCountryFilterList) {
		this.productCountryFilterList = productCountryFilterList;
	}
}