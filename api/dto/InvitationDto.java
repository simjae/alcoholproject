package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "invitation 테이블 Dto", description = "invitation 테이블 Dto")
public class InvitationDto {
	@ApiModelProperty(value = "초대 테이블 IDX")
	private int idx;
	@ApiModelProperty(value = "활동 테이블 IDX")
	private int activityIdx;
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "그룹 IDX")
	private int groupIdx;
	@ApiModelProperty(value = "초대 멤버 IDX")
	private int inviteMemberIdx;
	@ApiModelProperty(value = "컨텐츠")
	private String content;
	@ApiModelProperty(value = "초대 수락 플래그")
	private boolean acceptanceFlg;
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
	public int getGroupIdx() {
		return groupIdx;
	}
	public void setGroupIdx(int groupIdx) {
		this.groupIdx = groupIdx;
	}
	public int getInviteMemberIdx() {
		return inviteMemberIdx;
	}
	public void setInviteMemberIdx(int inviteMemberIdx) {
		this.inviteMemberIdx = inviteMemberIdx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isAcceptanceFlg() {
		return acceptanceFlg;
	}
	public void setAcceptanceFlg(boolean acceptanceFlg) {
		this.acceptanceFlg = acceptanceFlg;
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
