package com.bvdev.alcoholproject.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 검색용 필터 param Dto", description = "상품 검색용 필터 param Dto")
public class ProductSearchParamDto {
	private int memberIdx;
	private String productType;
	private int categoryIdx;
	private String aromaCategoryIdx;
	private int minPrice;
	private int maxPrice;
	private List<String> countryList;
	private Boolean activityFlg;
	
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getAromaCategoryIdx() {
		return aromaCategoryIdx;
	}
	public void setAromaCategoryIdx(String aromaCategoryIdx) {
		this.aromaCategoryIdx = aromaCategoryIdx;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public List<String> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}
	public Boolean getActivityFlg() {
		return activityFlg;
	}
	public void setActivityFlg(Boolean activityFlg) {
		this.activityFlg = activityFlg;
	}
}