package com.bvdev.alcoholproject.front.common.vo;

import com.bvdev.alcoholproject.api.dto.ReplyDto;

public class ReplyFormVo {
	private int primaryIdx;
	private int secondaryIdx;
	private String memberId;
	private ReplyDto replyDto;
	
	public int getPrimaryIdx() {
		return primaryIdx;
	}
	public void setPrimaryIdx(int primaryIdx) {
		this.primaryIdx = primaryIdx;
	}
	public int getSecondaryIdx() {
		return secondaryIdx;
	}
	public void setSecondaryIdx(int secondaryIdx) {
		this.secondaryIdx = secondaryIdx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public ReplyDto getReplyDto() {
		return replyDto;
	}
	public void setReplyDto(ReplyDto replyDto) {
		this.replyDto = replyDto;
	}
}