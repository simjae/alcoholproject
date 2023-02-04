package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "활동 점수 테이블 Dto")
public class ActivityScoreDto {
	@ApiModelProperty(value = "활동 점수 테이블 인덱스")
	private int idx;
	@ApiModelProperty(value = "활동 테이블 인덱스")
	private int activityIdx;
	@ApiModelProperty(value = "멤버 인덱스")
	private int memberIdx;
	@ApiModelProperty(value = "작성자")
	private Date createDate;
	@ApiModelProperty(value = "작성일자")
	private String creater;
	@ApiModelProperty(value = "수정자")
	private Date updateDate;
	@ApiModelProperty(value = "수정일자")
	private String updater;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
}