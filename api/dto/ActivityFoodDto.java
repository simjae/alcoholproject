package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "활동음식 Dto")
public class ActivityFoodDto {
	@ApiModelProperty(value = "활동음식 IDX")
	private int idx;
	@ApiModelProperty(value = "음식 정보 IDX 리스트")
	private String foodInfoIdx;
	@ApiModelProperty(value = "음식 정보 삭제 플래그")
	private Boolean activityFoodDelFlg;
	@ApiModelProperty(value = "등록자")
	private String creater;
	@ApiModelProperty(value = "등록일자")
	private Date createDate;
	@ApiModelProperty(value = "수정자")
	private String updater;
	@ApiModelProperty(value = "수정일자")
	private Date updateDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFoodInfoIdx() {
		return foodInfoIdx;
	}
	public void setFoodInfoIdx(String foodInfoIdx) {
		this.foodInfoIdx = foodInfoIdx;
	}
	public Boolean getActivityFoodDelFlg() {
		return activityFoodDelFlg;
	}
	public void setActivityFoodDelFlg(Boolean activityFoodDelFlg) {
		this.activityFoodDelFlg = activityFoodDelFlg;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}