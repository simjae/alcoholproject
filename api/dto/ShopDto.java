package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상점 Dto", description = "상점 Dto")
public class ShopDto {
	@ApiModelProperty(value = "상점 IDX")
	private int idx;
	@ApiModelProperty(value = "상점 이름")
	private int shopName;
	@ApiModelProperty(value = "행정구역 카테고리 IDX")
	private int addrCategoryIdx;
	@ApiModelProperty(value = "통합 주소")
	private String addr;
	@ApiModelProperty(value = "지번 주소")
	private String jibunAddr;
	@ApiModelProperty(value = "도로명 주소")
	private String roadAddr;
	@ApiModelProperty(value = "상세 주소")
	private String detailAddr;
	@ApiModelProperty(value = "위도")
	private String latitude;
	@ApiModelProperty(value = "경도")
	private String longitude;
	@ApiModelProperty(value = "상점 소개문구")
	private String description;
	@ApiModelProperty(value = "등록자")
	private String creater;
	@ApiModelProperty(value = "등록일자")
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
	public int getShopName() {
		return shopName;
	}
	public void setShopName(int shopName) {
		this.shopName = shopName;
	}
	public int getAddrCategoryIdx() {
		return addrCategoryIdx;
	}
	public void setAddrCategoryIdx(int addrCategoryIdx) {
		this.addrCategoryIdx = addrCategoryIdx;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJibunAddr() {
		return jibunAddr;
	}
	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
