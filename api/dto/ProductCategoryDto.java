package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상품 카테고리 Dto", description = "상품 카테고리 Dto")
public class ProductCategoryDto {
	@ApiModelProperty(value = "상품 카테고리 IDX")
	private int idx;
	@ApiModelProperty(value = "카테고리 타입")
	private String categoryType;
	@ApiModelProperty(value = "카테고리 이름")
	private String categoryName;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
