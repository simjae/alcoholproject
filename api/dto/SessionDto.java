package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "세션 Dto")
public class SessionDto {
	@ApiModelProperty(value = "idx")
	private int idx;
	@ApiModelProperty(value = "아이디")
	private String id;
	@ApiModelProperty(value = "이름")
	private String name;
	@ApiModelProperty(value = "표시 이름")
	private String displayName;
	@ApiModelProperty(value = "e-mail")
	private String email;
	@ApiModelProperty(value = "전화번호")
	private String mobile;
	@ApiModelProperty(value = "성별")
	private String gender;
	@ApiModelProperty(value = "생년월일")
	private String birth;
	@ApiModelProperty(value = "접속 IP")
	private String regIp;
	@ApiModelProperty(value = "로그인 iP")
	private String loginIp;
	@ApiModelProperty(value = "멤버 레벨")
	private int memberLevel;
	@ApiModelProperty(value = "멤버 경험치")
	private int memberExp;
	@ApiModelProperty(value = "모바일 토큰")
	private String token;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public int getMemberExp() {
		return memberExp;
	}
	public void setMemberExp(int memberExp) {
		this.memberExp = memberExp;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}