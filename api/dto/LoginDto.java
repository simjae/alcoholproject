package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "로그인 정보 Dto")
public class LoginDto {
	@ApiModelProperty(value = "아이디")
    private String id;
	@ApiModelProperty(value = "패스워드")
	private String password;
	@ApiModelProperty(value = "에러 메세지")
    private String errorMsg;
	@ApiModelProperty(value = "실패시 유저이동 url")
    private String FailUserUrl;

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
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getFailUserUrl() {
		return FailUserUrl;
	}
	public void setFailUserUrl(String failUserUrl) {
		FailUserUrl = failUserUrl;
	}
}