package com.bvdev.alcoholproject.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "활동 댓글 및 한줄평 데이터 반환용 Dto", description = "활동 댓글 및 한줄평 데이터 반환용 Dto")
public class ReplyDto {
	private int memberIdx;
	private int activityIdx;
	private int productIdx;
	private String displayName;
	private String content;
	private String strDate;
	private Boolean likeFlg;
	private String likeImg;
	private int likeNum;
	private int commentNum;
	@ApiModelProperty(value = "댓글 정보 취득용 MPTT 리스트")
	private List<Integer> mpttLeftList;
	private Boolean orderFlg;
	
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
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public Boolean getLikeFlg() {
		return likeFlg;
	}
	public void setLikeFlg(Boolean likeFlg) {
		this.likeFlg = likeFlg;
	}
	public String getLikeImg() {
		return likeImg;
	}
	public void setLikeImg(String likeImg) {
		this.likeImg = likeImg;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public List<Integer> getMpttLeftList() {
		return mpttLeftList;
	}
	public void setMpttLeftList(List<Integer> mpttLeftList) {
		this.mpttLeftList = mpttLeftList;
	}
	public Boolean getOrderFlg() {
		return orderFlg;
	}
	public void setOrderFlg(Boolean orderFlg) {
		this.orderFlg = orderFlg;
	}
}