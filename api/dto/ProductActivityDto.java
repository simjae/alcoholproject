package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "상품 한줄평 Dto", description = "상품 한줄평 Dto")
public class ProductActivityDto {
	private String bannerImg;
	private int activityIdx;
	private String activityGrade;
	private String activityLink;
	
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public int getActivityIdx() {
		return activityIdx;
	}
	public void setActivityIdx(int activityIdx) {
		this.activityIdx = activityIdx;
	}
	public String getActivityGrade() {
		return activityGrade;
	}
	public void setActivityGrade(String activityGrade) {
		this.activityGrade = activityGrade;
	}
	public String getActivityLink() {
		return activityLink;
	}
	public void setActivityLink(String activityLink) {
		this.activityLink = activityLink;
	}
}