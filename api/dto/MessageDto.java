package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "메세지 테이블 Dto", description = "메세지 테이블 Dto")
public class MessageDto {
	@ApiModelProperty(value = "메세지 idx")
	private int idx;
	@ApiModelProperty(value = "멤버 idx")
	private int memberIdx;
	@ApiModelProperty(value = "멤버 닉네임")
	private String displayName;
	@ApiModelProperty(value = "메세지 그룹 idx")
	private int messageGroupIdx;
	@ApiModelProperty(value = "메세지 컨텐츠")
	private String messageContent;
	@ApiModelProperty(value = "메세지 전송 시간")
	private Date messageSendTime;
	@ApiModelProperty(value = "메세지 전송자 프로필 사진")
	private String profileImg;
	@ApiModelProperty(value = "최근 실행 시간 TimeStamp")
	private String timeStamp;
	@ApiModelProperty(value = "본인 확인 플래그")
	private boolean senderFlg;
	@ApiModelProperty(value = "미확인 메세지 갯수")
	private int unreadCount;
	@ApiModelProperty(value = "미확인 메세지 플래그")
	private boolean unreadFlg;
	@ApiModelProperty(value = "전송 시간")
	private String strDate;
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
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getMessageGroupIdx() {
		return messageGroupIdx;
	}
	public void setMessageGroupIdx(int messageGroupIdx) {
		this.messageGroupIdx = messageGroupIdx;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageSendTime() {
		return messageSendTime;
	}
	public void setMessageSendTime(Date messageSendTime) {
		this.messageSendTime = messageSendTime;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public boolean isSenderFlg() {
		return senderFlg;
	}
	public void setSenderFlg(boolean senderFlg) {
		this.senderFlg = senderFlg;
	}
	public int getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	public boolean isUnreadFlg() {
		return unreadFlg;
	}
	public void setUnreadFlg(boolean unreadFlg) {
		this.unreadFlg = unreadFlg;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
}
