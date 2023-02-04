package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AlarmDto {
	@ApiModelProperty(value = "알람 문구")
	private String content;
	@ApiModelProperty(value = "상대방 ID")
	private String memberId;
	@ApiModelProperty(value = "알림 링크")
	private String alarmLink;
	@ApiModelProperty(value = "수정 일자")
	private Date createDate;
	@ApiModelProperty(value = "경과 시간")
	private String strDate;
	@ApiModelProperty(value = "아이콘 파일 경로&이름")
	private String imgFile;
	@ApiModelProperty(value = "알람 대상위치")
	private int	rownum;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAlarmLink() {
		return alarmLink;
	}
	public void setAlarmLink(String alarmLink) {
		this.alarmLink = alarmLink;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
}
