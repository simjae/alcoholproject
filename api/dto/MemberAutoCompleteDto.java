package com.bvdev.alcoholproject.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Member 정보 Dto", description = "Member 정보 Dto")
public class MemberAutoCompleteDto {
	private int memberIdx;
	private String memberId;
	private String displayName;
	private String profileImg;
	private List<String> tempMentionIdList;
	private String keyword;
	
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
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public List<String> getTempMentionIdList() {
		return tempMentionIdList;
	}
	public void setTempMentionIdList(List<String> tempMentionIdList) {
		this.tempMentionIdList = tempMentionIdList;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}