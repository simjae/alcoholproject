package com.bvdev.alcoholproject.front.product.vo;

import java.util.List;

import com.bvdev.alcoholproject.api.dto.ProductActivityDto;
import com.bvdev.alcoholproject.api.dto.ProductReplyDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductKeywordDto;
import com.bvdev.alcoholproject.api.dto.ProductRecommendDto;
import com.bvdev.alcoholproject.api.dto.ProductShopInfoDto;
import com.bvdev.alcoholproject.api.dto.TastingAromaDto;
import com.bvdev.alcoholproject.api.dto.TastingNoteDto;

public class ProductFormVo {
	private String memberId;
	private int productIdx;
	private ProductDto productDto;
	private String likeImg;
	private TastingAromaDto tastingAromaDto;
	private int activityNum;
	private List<ProductKeywordDto> productKeywordDtoList;
	private List<ProductActivityDto> productActivityDtoList;
	private List<ProductReplyDto> productReplyDtoList;
	private List<ProductShopInfoDto> productShopInfoDtoList;
	private TastingNoteDto tastingNoteDto;
	private List<ProductRecommendDto> productRecommendDtoList;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	public String getLikeImg() {
		return likeImg;
	}
	public void setLikeImg(String likeImg) {
		this.likeImg = likeImg;
	}
	public TastingAromaDto getTastingAromaDto() {
		return tastingAromaDto;
	}
	public void setTastingAromaDto(TastingAromaDto tastingAromaDto) {
		this.tastingAromaDto = tastingAromaDto;
	}
	public int getActivityNum() {
		return activityNum;
	}
	public void setActivityNum(int activityNum) {
		this.activityNum = activityNum;
	}
	public List<ProductKeywordDto> getProductKeywordDtoList() {
		return productKeywordDtoList;
	}
	public void setProductKeywordDtoList(List<ProductKeywordDto> productKeywordDtoList) {
		this.productKeywordDtoList = productKeywordDtoList;
	}
	public List<ProductActivityDto> getProductActivityDtoList() {
		return productActivityDtoList;
	}
	public void setProductActivityDtoList(List<ProductActivityDto> productActivityDtoList) {
		this.productActivityDtoList = productActivityDtoList;
	}
	public List<ProductReplyDto> getProductReplyDtoList() {
		return productReplyDtoList;
	}
	public void setProductReplyDtoList(List<ProductReplyDto> productReplyDtoList) {
		this.productReplyDtoList = productReplyDtoList;
	}
	public List<ProductShopInfoDto> getProductShopInfoDtoList() {
		return productShopInfoDtoList;
	}
	public void setProductShopInfoDtoList(List<ProductShopInfoDto> productShopInfoDtoList) {
		this.productShopInfoDtoList = productShopInfoDtoList;
	}
	public TastingNoteDto getTastingNoteDto() {
		return tastingNoteDto;
	}
	public void setTastingNoteDto(TastingNoteDto tastingNoteDto) {
		this.tastingNoteDto = tastingNoteDto;
	}
	public List<ProductRecommendDto> getProductRecommendDtoList() {
		return productRecommendDtoList;
	}
	public void setProductRecommendDtoList(List<ProductRecommendDto> productRecommendDtoList) {
		this.productRecommendDtoList = productRecommendDtoList;
	}
}