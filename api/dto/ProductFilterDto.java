package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 필터 Dto", description = "상품 필터 Dto")
public class ProductFilterDto {
	private int categoryIdx;
	private String categoryName;
	private int aromaIdx;
	private String aromaCategory;
	private String country;
	
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getAromaIdx() {
		return aromaIdx;
	}
	public void setAromaIdx(int aromaIdx) {
		this.aromaIdx = aromaIdx;
	}
	public String getAromaCategory() {
		return aromaCategory;
	}
	public void setAromaCategory(String aromaCategory) {
		this.aromaCategory = aromaCategory;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}