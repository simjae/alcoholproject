package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "미디어 테이블 Dto", description = "미디어 테이블 Dto")
public class MediaDto {
	@ApiModelProperty(value = "미디어 테이블 인덱스")
	private int idx;
	@ApiModelProperty(value = "멤버 테이블 인덱스")
	private int memberIdx;
	@ApiModelProperty(value = "활동 테이블 인덱스")
	private int activityIdx;
	@ApiModelProperty(value = "원본 파일명")
	private String originMediaFilename;
	@ApiModelProperty(value = "파일명")
	private String mediaFilename;
	@ApiModelProperty(value = "파일 종류")
	private String mediaType;
	@ApiModelProperty(value = "파일 게시 유형")
	private String mediaUploadType;
	@ApiModelProperty(value = "파일 삭제 플레그")
	private Boolean mediaDeleteFlg;
	@ApiModelProperty(value = "파일 사이즈")
	private long fileSize;
	@ApiModelProperty(value = "작성일")
	private Date createDate;
	@ApiModelProperty(value = "작성자")
	private String creater;
	@ApiModelProperty(value = "갱신일")
	private Date updateDate;
	@ApiModelProperty(value = "갱신자")
	private String updater;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getActivityIdx() {
		return activityIdx;
	}
	public void setActivityIdx(int activityIdx) {
		this.activityIdx = activityIdx;
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
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getMediaUploadType() {
		return mediaUploadType;
	}
	public void setMediaUploadType(String mediaUploadType) {
		this.mediaUploadType = mediaUploadType;
	}
	public Boolean getMediaDeleteFlg() {
		return mediaDeleteFlg;
	}
	public void setMediaDeleteFlg(Boolean mediaDeleteFlg) {
		this.mediaDeleteFlg = mediaDeleteFlg;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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