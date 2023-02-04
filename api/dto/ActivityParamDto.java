package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class ActivityParamDto {
	@ApiModelProperty(value = "활동 테이블 IDX")
	private int activityIdx;
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "상품 테이블 IDX")
	private int productIdx;
	@ApiModelProperty(value = "상품 타입")
	private String productType;
	@ApiModelProperty(value = "전체 멤버 피드 조회용 플래그")
	private Boolean selectMemberFlg;
	@ApiModelProperty(value = "입력 날짜 파라미터")
	private String dateParam;
	@ApiModelProperty(value = "좋아요 Flg")
	private Boolean likeFlg;
	@ApiModelProperty(value = "정렬 Flg")
	private Boolean orderFlg;
	@ApiModelProperty(value = "월간 검색 Flg")
	private Boolean monthFlg;
	
	public int getActivityIdx() {
		return activityIdx;
	}
	public void setActivityIdx(int activityIdx) {
		this.activityIdx = activityIdx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Boolean getSelectMemberFlg() {
		return selectMemberFlg;
	}
	public void setSelectMemberFlg(Boolean selectMemberFlg) {
		this.selectMemberFlg = selectMemberFlg;
	}
	public String getDateParam() {
		return dateParam;
	}
	public void setDateParam(String dateParam) {
		this.dateParam = dateParam;
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
	public Boolean getMonthFlg() {
		return monthFlg;
	}
	public void setMonthFlg(Boolean monthFlg) {
		this.monthFlg = monthFlg;
	}
}