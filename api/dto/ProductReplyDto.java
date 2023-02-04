package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 한줄평 Dto", description = "상품 한줄평 Dto")
public class ProductReplyDto {
	private String profileImg;
	private String content;
	private String replyLink;
	
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReplyLink() {
		return replyLink;
	}
	public void setReplyLink(String replyLink) {
		this.replyLink = replyLink;
	}
}