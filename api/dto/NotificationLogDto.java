package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "NotificationDto", description = "NotificationDto")
public class NotificationLogDto {
	private int idx;
	private int memberIdx;
	private int logMemberIdx;
	private String logMemberId;
	private Date createDate;
	private String creater;
	private Date updateDate;
	private String updater;
	
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
	public int getLogMemberIdx() {
		return logMemberIdx;
	}
	public void setLogMemberIdx(int logMemberIdx) {
		this.logMemberIdx = logMemberIdx;
	}
	public String getLogMemberId() {
		return logMemberId;
	}
	public void setLogMemberId(String logMemberId) {
		this.logMemberId = logMemberId;
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