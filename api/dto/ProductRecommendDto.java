package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "추천 상품 Dto", description = "추천 상품 Dto")
public class ProductRecommendDto {
	private int productIdx;
	private String productImg;
	private int likeNum;
	private String likeImg;
	private String productLink;
	
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getLikeImg() {
		return likeImg;
	}
	public void setLikeImg(String likeImg) {
		this.likeImg = likeImg;
	}
	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
}