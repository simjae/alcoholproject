package com.bvdev.alcoholproject.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Api 결과정보 Dto", description = "결과정보")
public class ApiAutoCompleteDto {
	private boolean success;
	private List<ProductAutoCompleteDto> productData;
	private List<AddrAutoCompleteDto> addrData;
	private List<FoodInfoDto> foodData;
	private List<MemberAutoCompleteDto> memberData;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ProductAutoCompleteDto> getProductData() {
		return productData;
	}
	public void setProductData(List<ProductAutoCompleteDto> productData) {
		this.productData = productData;
	}
	public List<AddrAutoCompleteDto> getAddrData() {
		return addrData;
	}
	public void setAddrData(List<AddrAutoCompleteDto> addrData) {
		this.addrData = addrData;
	}
	public List<FoodInfoDto> getFoodData() {
		return foodData;
	}
	public void setFoodData(List<FoodInfoDto> foodData) {
		this.foodData = foodData;
	}
	public List<MemberAutoCompleteDto> getMemberData() {
		return memberData;
	}
	public void setMemberData(List<MemberAutoCompleteDto> memberData) {
		this.memberData = memberData;
	}
}