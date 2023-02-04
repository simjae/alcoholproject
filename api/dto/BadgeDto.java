package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "뱃지 테이블 Dto")

public class BadgeDto {
	@ApiModelProperty(value = "멤버 뱃지 테이블 인덱스")
	private int badgeIdx;
	@ApiModelProperty(value = "뱃지 이름")
    private String badgeName;
	@ApiModelProperty(value = "뱃지 이미지 파일명")
    private String badgeImgFilename;
	@ApiModelProperty(value = "멤버 뱃지 테이블 인덱스")
    private int memberBadgeIdx;
	
    public int getBadgeIdx() {
		return badgeIdx;
	}
	public void setBadgeIdx(int badgeIdx) {
		this.badgeIdx = badgeIdx;
	}
	public String getBadgeName() {
		return badgeName;
	}
	public int getMemberBadgeIdx() {
		return memberBadgeIdx;
	}
	public void setMemberBadgeIdx(int memberBadgeIdx) {
		this.memberBadgeIdx = memberBadgeIdx;
	}
	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}
	public String getBadgeImgFilename() {
		return badgeImgFilename;
	}
	public void setBadgeImgFilename(String badgeImgFilename) {
		this.badgeImgFilename = badgeImgFilename;
	}
}