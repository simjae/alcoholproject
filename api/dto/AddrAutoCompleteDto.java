package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "활동 주소 자동완성 정보 취득용 Dto", description = "활동 주소 자동완성 정보 취득용 Dto")
public class AddrAutoCompleteDto {
	private int addrIdx;
	private String addrName;
	private String roadAddr;
	private String detailAddr;
	
	public int getAddrIdx() {
		return addrIdx;
	}
	public void setAddrIdx(int addrIdx) {
		this.addrIdx = addrIdx;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
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
}