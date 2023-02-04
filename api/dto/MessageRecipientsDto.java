package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "메세지 수취  정보 Dto", description = "메세지 수취  정보 Dto")
public class MessageRecipientsDto {
	@ApiModelProperty(value = "메시지 수취 테이블 IDX")
	private int idx;
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "메시지 그룹 IDX")
	private int messageGroupIdx;
	@ApiModelProperty(value = "미확인 메시지 카운트")
	private int unreadCount;
	@ApiModelProperty(value = "메시지 답신 확인 플래그")
	private int senderOnlyFlg;
	@ApiModelProperty(value = "메시지 삭제 플래그")
	private int messageDeletedFlg;
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
	public int getMessageGroupIdx() {
		return messageGroupIdx;
	}
	public void setMessageGroupIdx(int messageGroupIdx) {
		this.messageGroupIdx = messageGroupIdx;
	}
	public int getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	public int getSenderOnlyFlg() {
		return senderOnlyFlg;
	}
	public void setSenderOnlyFlg(int senderOnlyFlg) {
		this.senderOnlyFlg = senderOnlyFlg;
	}
	public int getMessageDeletedFlg() {
		return messageDeletedFlg;
	}
	public void setMessageDeletedFlg(int messageDeletedFlg) {
		this.messageDeletedFlg = messageDeletedFlg;
	}
	
}
