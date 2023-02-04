package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "활동상품 Dto", description = "활동상품 Dto")
public class ActivityProductLogDto {
	@ApiModelProperty(value = "활동 상품 로그 IDX")
	private int idx;
	@ApiModelProperty(value = "멤버 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "로그 상품 IDX")
	private int logProductIdx;
	@ApiModelProperty(value = "로그 상품 이름")
	private String logProductName;
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
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getLogProductIdx() {
		return logProductIdx;
	}
	public void setLogProductIdx(int logProductIdx) {
		this.logProductIdx = logProductIdx;
	}
	public String getLogProductName() {
		return logProductName;
	}
	public void setLogProductName(String logProductName) {
		this.logProductName = logProductName;
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