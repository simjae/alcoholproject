package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "멤버 커뮤니티 테이블 Dto")
public class MemCommunityDto {
	@ApiModelProperty(value = "")
	private String mCommHostId;
	@ApiModelProperty(value = "")
	private int mCommIdx;
	@ApiModelProperty(value = "")
	private String mComm_bannerImg;
	@ApiModelProperty(value = "")
	private String mCommSubGrade;
	@ApiModelProperty(value = "")
	private String mCommName;
	@ApiModelProperty(value = "")
	private String mCommAddr;
	@ApiModelProperty(value = "")
	private Date mCommStartDate;
	@ApiModelProperty(value = "")
	private Date mCommEndDate;
	@ApiModelProperty(value = "")
	private Boolean mCommOnlineFlg;
	@ApiModelProperty(value = "")
	private Date createDate;
	@ApiModelProperty(value = "")
	private String creater;
	@ApiModelProperty(value = "")
	private Date updateDate;
	@ApiModelProperty(value = "")
	private String updater;
	
	public String getmCommHostId() {
		return mCommHostId;
	}
	public void setmCommHostId(String mCommHostId) {
		this.mCommHostId = mCommHostId;
	}
	public int getmCommIdx() {
		return mCommIdx;
	}
	public void setmCommIdx(int mCommIdx) {
		this.mCommIdx = mCommIdx;
	}
	public String getmComm_bannerImg() {
		return mComm_bannerImg;
	}
	public void setmComm_bannerImg(String mComm_bannerImg) {
		this.mComm_bannerImg = mComm_bannerImg;
	}
	public String getmCommSubGrade() {
		return mCommSubGrade;
	}
	public void setmCommSubGrade(String mCommSubGrade) {
		this.mCommSubGrade = mCommSubGrade;
	}
	public String getmCommName() {
		return mCommName;
	}
	public void setmCommName(String mCommName) {
		this.mCommName = mCommName;
	}
	public String getmCommAddr() {
		return mCommAddr;
	}
	public void setmCommAddr(String mCommAddr) {
		this.mCommAddr = mCommAddr;
	}
	public Date getmCommStartDate() {
		return mCommStartDate;
	}
	public void setmCommStartDate(Date mCommStartDate) {
		this.mCommStartDate = mCommStartDate;
	}
	public Date getmCommEndDate() {
		return mCommEndDate;
	}
	public void setmCommEndDate(Date mCommEndDate) {
		this.mCommEndDate = mCommEndDate;
	}
	public Boolean getmCommOnlineFlg() {
		return mCommOnlineFlg;
	}
	public void setmCommOnlineFlg(Boolean mCommOnlineFlg) {
		this.mCommOnlineFlg = mCommOnlineFlg;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
}