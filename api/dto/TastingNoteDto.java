package com.bvdev.alcoholproject.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "테이스팅 노트 Dto", description = "테이스팅 노트 Dto")
public class TastingNoteDto {
	@ApiModelProperty(value = "테이스팅 노트 IDX")
	private int idx;
	@ApiModelProperty(value = "색상")
	private String color;
	@ApiModelProperty(value = "활동 IDX")
	private int activityIdx;
	@ApiModelProperty(value = "마시기 전 Aroma(향) IDX")
	private int aromaBeforeIdx;
	@ApiModelProperty(value = "마시는 중 Aroma(향) IDX")
	private int aromaWhileIdx;
	@ApiModelProperty(value = "마신 후의 Aroma(향) IDX")
	private int aromaAfterIdx;
	@ApiModelProperty(value = "테이스팅 설명항목 01")
	private String tastingDesc01;
	@ApiModelProperty(value = "테이스팅 설명항목 02")
	private String tastingDesc02;
	@ApiModelProperty(value = "테이스팅 설명항목 03")
	private String tastingDesc03;
	@ApiModelProperty(value = "테이스팅 설명항목 04")
	private String tastingDesc04;
	@ApiModelProperty(value = "테이스팅 설명항목 05")
	private String tastingDesc05;
	@ApiModelProperty(value = "테이스팅 설명항목 06")
	private String tastingDesc06;
	@ApiModelProperty(value = "테이스팅 설명항목 07")
	private String tastingDesc07;
	@ApiModelProperty(value = "테이스팅 설명항목 08")
	private String tastingDesc08;
	@ApiModelProperty(value = "테이스팅 설명항목 09")
	private String tastingDesc09;
	@ApiModelProperty(value = "테이스팅 설명항목 10")
	private String tastingDesc10;
	@ApiModelProperty(value = "음식 점수")
	private int foodGrade;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getActivityIdx() {
		return activityIdx;
	}
	public void setActivityIdx(int activityIdx) {
		this.activityIdx = activityIdx;
	}
	public int getAromaBeforeIdx() {
		return aromaBeforeIdx;
	}
	public void setAromaBeforeIdx(int aromaBeforeIdx) {
		this.aromaBeforeIdx = aromaBeforeIdx;
	}
	public int getAromaWhileIdx() {
		return aromaWhileIdx;
	}
	public void setAromaWhileIdx(int aromaWhileIdx) {
		this.aromaWhileIdx = aromaWhileIdx;
	}
	public int getAromaAfterIdx() {
		return aromaAfterIdx;
	}
	public void setAromaAfterIdx(int aromaAfterIdx) {
		this.aromaAfterIdx = aromaAfterIdx;
	}
	public String getTastingDesc01() {
		return tastingDesc01;
	}
	public void setTastingDesc01(String tastingDesc01) {
		this.tastingDesc01 = tastingDesc01;
	}
	public String getTastingDesc02() {
		return tastingDesc02;
	}
	public void setTastingDesc02(String tastingDesc02) {
		this.tastingDesc02 = tastingDesc02;
	}
	public String getTastingDesc03() {
		return tastingDesc03;
	}
	public void setTastingDesc03(String tastingDesc03) {
		this.tastingDesc03 = tastingDesc03;
	}
	public String getTastingDesc04() {
		return tastingDesc04;
	}
	public void setTastingDesc04(String tastingDesc04) {
		this.tastingDesc04 = tastingDesc04;
	}
	public String getTastingDesc05() {
		return tastingDesc05;
	}
	public void setTastingDesc05(String tastingDesc05) {
		this.tastingDesc05 = tastingDesc05;
	}
	public String getTastingDesc06() {
		return tastingDesc06;
	}
	public void setTastingDesc06(String tastingDesc06) {
		this.tastingDesc06 = tastingDesc06;
	}
	public String getTastingDesc07() {
		return tastingDesc07;
	}
	public void setTastingDesc07(String tastingDesc07) {
		this.tastingDesc07 = tastingDesc07;
	}
	public String getTastingDesc08() {
		return tastingDesc08;
	}
	public void setTastingDesc08(String tastingDesc08) {
		this.tastingDesc08 = tastingDesc08;
	}
	public String getTastingDesc09() {
		return tastingDesc09;
	}
	public void setTastingDesc09(String tastingDesc09) {
		this.tastingDesc09 = tastingDesc09;
	}
	public String getTastingDesc10() {
		return tastingDesc10;
	}
	public void setTastingDesc10(String tastingDesc10) {
		this.tastingDesc10 = tastingDesc10;
	}
	public int getFoodGrade() {
		return foodGrade;
	}
	public void setFoodGrade(int foodGrade) {
		this.foodGrade = foodGrade;
	}
}
