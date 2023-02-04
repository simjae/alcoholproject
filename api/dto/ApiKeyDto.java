package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "API KEY 마스터 테이블 Dto")
public class ApiKeyDto {
	@ApiModelProperty(value = "Api 키 테이블 인덱스")
	private String idx;
	@ApiModelProperty(value = "Api 키값")
	private String keyValue;
	@ApiModelProperty(value = "Api 키 설명")
	private String keyComment;
	@ApiModelProperty(value = "권한 등급")
	private int authGrade;
	@ApiModelProperty(value = "작성자")
	private String creater;
	@ApiModelProperty(value = "작성일자")
	private Date createDate;
	@ApiModelProperty(value = "수정자")
	private String updater;
	@ApiModelProperty(value = "수정일자")
	private Date updateDate;
	
	public String getIdx() {
		return idx;
	}
	public void setId(String idx) {
		this.idx = idx;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getKeyComment() {
		return keyComment;
	}
	public void setKeyComment(String keyComment) {
		this.keyComment = keyComment;
	}
	public int getAuthGrade() {
		return authGrade;
	}
	public void setAuthGrade(int authGrade) {
		this.authGrade = authGrade;
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