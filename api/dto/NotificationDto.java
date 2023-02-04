package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NotificationDto", description = "NotificationDto")
public class NotificationDto {
	@ApiModelProperty(value = "알림 테이블 IDX")
	private int idx;
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "멤버 테이블 ID")
	private String memberId;
	@ApiModelProperty(value = "멤버의 표시 이름")
	private String displayName;
	@ApiModelProperty(value = "활동 테이블 IDX")
	private int activityIdx;
	@ApiModelProperty(value = "알림 확인 플래그")
	private boolean confirmFlg;
	@ApiModelProperty(value = "작성일")
	private Date createDate;
	@ApiModelProperty(value = "작성자")
	private String creater;
	
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getActivityIdx() {
		return activityIdx;
	}
	public void setActivityIdx(int activityIdx) {
		this.activityIdx = activityIdx;
	}
	public boolean isConfirmFlg() {
		return confirmFlg;
	}
	public void setConfirmFlg(boolean confirmFlg) {
		this.confirmFlg = confirmFlg;
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
}