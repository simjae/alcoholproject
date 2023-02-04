package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "상품 이미지 Dto", description = "상품 이미지 Dto")
public class ProductImageDto {
	@ApiModelProperty(value = "상품 이미지 IDX")
	private int idx;
	@ApiModelProperty(value = "상품 IDX")
	private int productIdx;
	@ApiModelProperty(value = "원본 파일명")
	private String originMediaFilename;
	@ApiModelProperty(value = "파일명")
	private String mediaFilename;
	@ApiModelProperty(value = "이미지 삭제 플레그")
	private Boolean imgDelFlg;
	@ApiModelProperty(value = "검증 플레그")
	private Boolean verifyFlg;
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
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getOriginMediaFilename() {
		return originMediaFilename;
	}
	public void setOriginMediaFilename(String originMediaFilename) {
		this.originMediaFilename = originMediaFilename;
	}
	public String getMediaFilename() {
		return mediaFilename;
	}
	public void setMediaFilename(String mediaFilename) {
		this.mediaFilename = mediaFilename;
	}
	public Boolean getImgDelFlg() {
		return imgDelFlg;
	}
	public void setImgDelFlg(Boolean imgDelFlg) {
		this.imgDelFlg = imgDelFlg;
	}
	public Boolean getVerifyFlg() {
		return verifyFlg;
	}
	public void setVerifyFlg(Boolean verifyFlg) {
		this.verifyFlg = verifyFlg;
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
