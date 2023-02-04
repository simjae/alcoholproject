package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 정보 취득용 Param Dto", description = "상품 정보 취득용 Param Dto")
public class ProductParamDto {
	private int productIdx;
	private int memberIdx;
	private Boolean likeFlg;
	private Boolean orderFlg;
	
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public Boolean getLikeFlg() {
		return likeFlg;
	}
	public void setLikeFlg(Boolean likeFlg) {
		this.likeFlg = likeFlg;
	}
	public Boolean getOrderFlg() {
		return orderFlg;
	}
	public void setOrderFlg(Boolean orderFlg) {
		this.orderFlg = orderFlg;
	}
}