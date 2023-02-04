package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 판매처 정보 Dto", description = "상품 판매처 정보 Dto")
public class ProductShopInfoDto {
	private String shopImg;
	private String shopName;
	private String sellPrice;
	
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
}