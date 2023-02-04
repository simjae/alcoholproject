package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "테이스팅 향 Dto", description = "테이스팅 향 Dto")
public class TastingAromaDto {
	@ApiModelProperty(value = "테이스팅 향 IDX")
	private int idx;
	@ApiModelProperty(value = "Aroma 정보")
	private String aromaInfo;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getAromaInfo() {
		return aromaInfo;
	}
	public void setAromaInfo(String aromaInfo) {
		this.aromaInfo = aromaInfo;
	}
}
