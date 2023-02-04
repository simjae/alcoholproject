package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "활동 주소 로그 Dto", description = "활동 주소 로그 Dto")
public class ActivityAddrLogDto {
	@ApiModelProperty(value = "활동 주소 로그IDX")
	private int idx;
	private int memberIdx;
	private int logAddrIdx;
	private String logAddrName;
	private String creater;
	private Date createDate;
	private String updater;
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
	public int getLogAddrIdx() {
		return logAddrIdx;
	}
	public void setLogAddrIdx(int logAddrIdx) {
		this.logAddrIdx = logAddrIdx;
	}
	public String getLogAddrName() {
		return logAddrName;
	}
	public void setLogAddrName(String logAddrName) {
		this.logAddrName = logAddrName;
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