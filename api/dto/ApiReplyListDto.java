package com.bvdev.alcoholproject.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApiReplyListDto", description = "하나의 활동글에 포함된 reply리스트")
public class ApiReplyListDto {
	@ApiModelProperty(value="ReplyDto List")
	private List<ReplyDto> replyDtoList;
	@ApiModelProperty(value="result Message")
	private String message;
	private int resultCount;
	
	public List<ReplyDto> getReplyDtoList() {
		return replyDtoList;
	}
	public void setReplyDtoList(List<ReplyDto> replyDtoList) {
		this.replyDtoList = replyDtoList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
}