package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "활동 음식 자동완성 정보 취득용 Dto", description = "활동 음식 자동완성 정보 취득용 Dto")
public class FoodAutoCompleteDto {
	private int foodIdx;
	private String foodName;
	private int activityCnt;
	private String keyword;
	private String korKeywordHead;
	private String korKeywordTail;
	private Boolean korKeywordHeadFlg;
	private Boolean korKeywordTailFlg;
	
	public int getFoodIdx() {
		return foodIdx;
	}
	public void setFoodIdx(int foodIdx) {
		this.foodIdx = foodIdx;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getActivityCnt() {
		return activityCnt;
	}
	public void setActivityCnt(int activityCnt) {
		this.activityCnt = activityCnt;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKorKeywordHead() {
		return korKeywordHead;
	}
	public void setKorKeywordHead(String korKeywordHead) {
		this.korKeywordHead = korKeywordHead;
	}
	public String getKorKeywordTail() {
		return korKeywordTail;
	}
	public void setKorKeywordTail(String korKeywordTail) {
		this.korKeywordTail = korKeywordTail;
	}
	public Boolean getKorKeywordHeadFlg() {
		return korKeywordHeadFlg;
	}
	public void setKorKeywordHeadFlg(Boolean korKeywordHeadFlg) {
		this.korKeywordHeadFlg = korKeywordHeadFlg;
	}
	public Boolean getKorKeywordTailFlg() {
		return korKeywordTailFlg;
	}
	public void setKorKeywordTailFlg(Boolean korKeywordTailFlg) {
		this.korKeywordTailFlg = korKeywordTailFlg;
	}
}