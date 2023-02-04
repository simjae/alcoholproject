package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상품 키워드 Dto", description = "상품 키워드 Dto")
public class ProductKeywordDto {
	@ApiModelProperty(value = "상품 키워드 IDX")
	private int idx;
	@ApiModelProperty(value = "상품 idx")
	private int productIdx;
	@ApiModelProperty(value = "상품 키워드")
	private String keyword;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
