package com.bvdev.alcoholproject.front.activity.vo;

import java.util.List;

import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.MediaDto;

public class UpdateFormVo {
	private String memberId;
	private ActivityDto activityDto;
	private List<MediaDto> mediaDtoList;
	private String filenameArr;
	private String productNameKor;
	private String productNameEng;
	private String sellPrice;
	private String foodInfoIdxList;
	private List<FoodInfoDto> foodInfoDtoList;
	private String mentionIdList;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public ActivityDto getActivityDto() {
		return activityDto;
	}
	public void setActivityDto(ActivityDto activityDto) {
		this.activityDto = activityDto;
	}
	public List<MediaDto> getMediaDtoList() {
		return mediaDtoList;
	}
	public void setMediaDtoList(List<MediaDto> mediaDtoList) {
		this.mediaDtoList = mediaDtoList;
	}
	public String getFilenameArr() {
		return filenameArr;
	}
	public void setFilenameArr(String filenameArr) {
		this.filenameArr = filenameArr;
	}
	public String getProductNameKor() {
		return productNameKor;
	}
	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}
	public String getProductNameEng() {
		return productNameEng;
	}
	public void setProductNameEng(String productNameEng) {
		this.productNameEng = productNameEng;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getFoodInfoIdxList() {
		return foodInfoIdxList;
	}
	public void setFoodInfoIdxList(String foodInfoIdxList) {
		this.foodInfoIdxList = foodInfoIdxList;
	}
	public List<FoodInfoDto> getFoodInfoDtoList() {
		return foodInfoDtoList;
	}
	public void setFoodInfoDtoList(List<FoodInfoDto> foodInfoDtoList) {
		this.foodInfoDtoList = foodInfoDtoList;
	}
	public String getMentionIdList() {
		return mentionIdList;
	}
	public void setMentionIdList(String mentionIdList) {
		this.mentionIdList = mentionIdList;
	}
}