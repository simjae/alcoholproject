package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상품 정보 테이블 Dto", description = "상품 정보 테이블 Dto")
public class ProductDto {
	@ApiModelProperty(value = "상품 idx")
	private int idx;
	@ApiModelProperty(value = "상품 고유번호")
	private String productSku;
	@ApiModelProperty(value = "카테고리 idx")
	private int categoryIdx;
	@ApiModelProperty(value = "카테고리 명")
	private String categoryName;
	@ApiModelProperty(value = "상품 바코드")
	private String productBarcode;
	@ApiModelProperty(value = "상품 평균 점수")
	private String avgGrade;
	@ApiModelProperty(value = "상품 이름 한글명")
	private String productNameKor;
	@ApiModelProperty(value = "상품 이름 영문명")
	private String productNameEng;
	@ApiModelProperty(value = "수입 업체")
	private String incCompany;
	@ApiModelProperty(value = "제조 업소명")
	private String manCompany;
	@ApiModelProperty(value = "제조 국가")
	private String country;
	@ApiModelProperty(value = "제조 지역")
	private String region;
	@ApiModelProperty(value = "제조 년ㄷ")
	private int productionYear;
	@ApiModelProperty(value = "도수")
	private float alcoholPer;
	@ApiModelProperty(value = "용량")
	private int productVolume;
	@ApiModelProperty(value = "재조 재료")
	private String material;
	@ApiModelProperty(value = "설명")
	private String description;
	@ApiModelProperty(value = "상품 설명항목 01")
	private String productDesc01;
	@ApiModelProperty(value = "상품 설명항목 02")
	private String productDesc02;
	@ApiModelProperty(value = "상품 설명항목 03")
	private String productDesc03;
	@ApiModelProperty(value = "상품 설명항목 04")
	private String productDesc04;
	@ApiModelProperty(value = "비비노 평점")
	private String productGrade;
	@ApiModelProperty(value = "판매가격")
	private String sellPrice;
	@ApiModelProperty(value = "상품의 좋아요 확인용 플래그")
	private Boolean likeFlg;
	@ApiModelProperty(value = "상품의 좋아요 수")
	private int likeNum;
	@ApiModelProperty(value = "작성자")
	private String creater;
	@ApiModelProperty(value = "작성일자")
	private Date createDate;
	@ApiModelProperty(value = "수정자")
	private String updater;
	@ApiModelProperty(value = "수정일자")
	private Date updateDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductBarcode() {
		return productBarcode;
	}
	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}
	public String getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(String avgGrade) {
		this.avgGrade = avgGrade;
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
	public String getIncCompany() {
		return incCompany;
	}
	public void setIncCompany(String incCompany) {
		this.incCompany = incCompany;
	}
	public String getManCompany() {
		return manCompany;
	}
	public void setManCompany(String manCompany) {
		this.manCompany = manCompany;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public float getAlcoholPer() {
		return alcoholPer;
	}
	public void setAlcoholPer(float alcoholPer) {
		this.alcoholPer = alcoholPer;
	}
	public int getProductVolume() {
		return productVolume;
	}
	public void setProductVolume(int productVolume) {
		this.productVolume = productVolume;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductDesc01() {
		return productDesc01;
	}
	public void setProductDesc01(String productDesc01) {
		this.productDesc01 = productDesc01;
	}
	public String getProductDesc02() {
		return productDesc02;
	}
	public void setProductDesc02(String productDesc02) {
		this.productDesc02 = productDesc02;
	}
	public String getProductDesc03() {
		return productDesc03;
	}
	public void setProductDesc03(String productDesc03) {
		this.productDesc03 = productDesc03;
	}
	public String getProductDesc04() {
		return productDesc04;
	}
	public void setProductDesc04(String productDesc04) {
		this.productDesc04 = productDesc04;
	}
	public String getProductGrade() {
		return productGrade;
	}
	public void setProductGrade(String productGrade) {
		this.productGrade = productGrade;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Boolean getLikeFlg() {
		return likeFlg;
	}
	public void setLikeFlg(Boolean likeFlg) {
		this.likeFlg = likeFlg;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
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