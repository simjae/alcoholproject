package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "마이페이지 정보 Dto")
public class MypageDto {
	@ApiModelProperty(value = "멤버 이름")
	private String memberName;
	@ApiModelProperty(value = "멤버 주소")
	private String memberAddr;
	@ApiModelProperty(value = "멤버 레벨")
	private int memberLevel;
	@ApiModelProperty(value = "멤버 레벨 이름")
    private String memberLevelName;
    
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberLevelName() {
		return memberLevelName;
	}
	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}
}