package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Member 정보 Dto", description = "Member 정보 Dto")
public class MemberDto {
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int idx;
	@ApiModelProperty(value = "로그인 ID")
	private String id;
	@ApiModelProperty(value = "로그인 PW")
	private String password;
	@ApiModelProperty(value = "이름")
	private String name;
	@ApiModelProperty(value = "표시 이름")
	private String displayName;
	@ApiModelProperty(value = "미디어 테이블 인덱스")
	private int mediaIdx;
	@ApiModelProperty(value = "이메일")
	private String address;
	@ApiModelProperty(value = "멤버 주소")
	private String email;
	@ApiModelProperty(value = "휴대전화 번호")
	private String mobile;
	@ApiModelProperty(value = "성별")
	private String gender;
	@ApiModelProperty(value = "생년월일")
	private String birth;
	@ApiModelProperty(value = "PUSH 메시지 동")
	private Boolean pushYn;
	@ApiModelProperty(value = "가입 IP")
	private String regIp;
	@ApiModelProperty(value = "가입 일시")
	private Date regDate;
	@ApiModelProperty(value = "로그인 IP")
	private String loginIp;
	@ApiModelProperty(value = "마지막 로그인 일자")
	private Date loginDate;
	@ApiModelProperty(value = "로그인 횟수")
	private int loginCnt;
	@ApiModelProperty(value = "승인키")
	private String activationKey;
	@ApiModelProperty(value = "유저 상태")
	private Boolean memberStatus;
	@ApiModelProperty(value = "멤버 레벨")
	private int memberLevel;
	@ApiModelProperty(value = "멤버 경험치")
	private int memberExp;
	@ApiModelProperty(value = "모바일 토큰 취득 단말")
	private String tokenDevice;
	@ApiModelProperty(value = "모바일 토큰")
	private String token;
	@ApiModelProperty(value = "멤버 삭제 플래그")
	private Boolean memberDelFlg;
	@ApiModelProperty(value = "갱신일")
	private Date updateDate;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getMediaIdx() {
		return mediaIdx;
	}
	public void setMediaIdx(int mediaIdx) {
		this.mediaIdx = mediaIdx;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Boolean getPushYn() {
		return pushYn;
	}
	public void setPushYn(Boolean pushYn) {
		this.pushYn = pushYn;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public int getLoginCnt() {
		return loginCnt;
	}
	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}
	public String getActivationKey() {
		return activationKey;
	}
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	public Boolean getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(Boolean memberStatus) {
		this.memberStatus = memberStatus;
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
	public String getTokenDevice() {
		return tokenDevice;
	}
	public void setTokenDevice(String tokenDevice) {
		this.tokenDevice = tokenDevice;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getMemberDelFlg() {
		return memberDelFlg;
	}
	public void setMemberDelFlg(Boolean memberDelFlg) {
		this.memberDelFlg = memberDelFlg;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}