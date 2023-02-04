package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상품 추가 정보 Dto", description = "상품 추가 정보 Dto")
public class ProductExtraInfoDto {
	@ApiModelProperty(value = "상품 추가정보 IDX")
	private int idx;
	@ApiModelProperty(value = "평점")
	private String productGrade;
	@ApiModelProperty(value = "검색 수")
	private int searchCnt;
	@ApiModelProperty(value = "등록 수")
	private int registCnt;
	@ApiModelProperty(value = "판매 가격")
	private int sellPrice;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getProductGrade() {
		return productGrade;
	}
	public void setProductGrade(String productGrade) {
		this.productGrade = productGrade;
	}
	public int getSearchCnt() {
		return searchCnt;
	}
	public void setSearchCnt(int searchCnt) {
		this.searchCnt = searchCnt;
	}
	public int getRegistCnt() {
		return registCnt;
	}
	public void setRegistCnt(int registCnt) {
		this.registCnt = registCnt;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
}