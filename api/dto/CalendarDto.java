package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "활동 정보 테이블 Dto")
public class CalendarDto {
	@ApiModelProperty(value = "주류 타입")
	private String productType;
	@ApiModelProperty(value = "일자")
	private String Date;
	@ApiModelProperty(value = "활동 여부 Flg")
	private boolean activityFlg;
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public boolean isActivityFlg() {
		return activityFlg;
	}
	public void setActivityFlg(boolean activityFlg) {
		this.activityFlg = activityFlg;
	}
}