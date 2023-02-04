package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "활동 상품 자동완성 정보 취득용 Dto", description = "활동 상품 자동완성 정보 취득용 Dto")
public class ProductAutoCompleteDto {
	private int productIdx;
	private String productNameKor;
	private String productNameEng;
	private String categoryName;
	private String country;
	private float alcoholPer;
	private int sellPrice;
	
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getProductNameKor() {
		return productNameKor;
	}
	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}
	public String getProductNameEng() {
		return productNameEng;
	}
	public void setProductNameEng(String productNameEng) {
		this.productNameEng = productNameEng;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public float getAlcoholPer() {
		return alcoholPer;
	}
	public void setAlcoholPer(float alcoholPer) {
		this.alcoholPer = alcoholPer;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
}