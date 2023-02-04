package com.bvdev.alcoholproject.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "활동 정보 테이블 Dto")
public class ActivityDto {
	@ApiModelProperty(value = "활동 테이블 IDX")
	private int idx;
	@ApiModelProperty(value = "그룹 테이블 IDX")
	private int groupIdx;
	@ApiModelProperty(value = "멤버 테이블 IDX")
	private int memberIdx;
	@ApiModelProperty(value = "상품 테이블 IDX")
	private int productIdx;
	@ApiModelProperty(value = "활동 상품 명")
	private String productNameKor;
	@ApiModelProperty(value = "활동 상품 가격")
	private String sellPrice;
	@ApiModelProperty(value = "활동 타입")
	private String type;
	@ApiModelProperty(value = "활동 액션")
	private String action;
	@ApiModelProperty(value = "알림 링크")
	private String noticeLink;
	@ApiModelProperty(value = "활동 컨텐츠")
	private String content;
	@ApiModelProperty(value = "활동 주소 IDX")
	private int activityAddrIdx;
	@ApiModelProperty(value = "활동 주소 aud")
	private String addrName;
	@ApiModelProperty(value = "활동 음식 IDX")
	private int activityFoodIdx;
	@ApiModelProperty(value = "활동 상품 점수")
	private String activityGrade;
	@ApiModelProperty(value = "활동 미리보기 이미지")
	private String mediaFilename;
	@ApiModelProperty(value = "1차지수")
	private int primaryIdx;
	@ApiModelProperty(value = "2차지수")
	private int secondaryIdx;
	@ApiModelProperty(value = "트리 왼쪽")
	private int mpttLeft;
	@ApiModelProperty(value = "트리 오른쪽")
	private int mpttRight;
	@ApiModelProperty(value = "활동 좋아요 카운트")
	private int likeNum;
	@ApiModelProperty(value = "활동 좋아요 액션 판단용 플래그")
	private Boolean likeFlg;
	@ApiModelProperty(value = "활동 삭제 플래그")
	private Boolean activityDelFlg;
	@ApiModelProperty(value = "활동 숨김 플래그")
	private Boolean activityHiddenFlg;
	@ApiModelProperty(value = "활동 숨김 이미지")
	private String activityHiddenImg;
	@ApiModelProperty(value = "작성일")
	private Date createDate;
	@ApiModelProperty(value = "작성자")
	private String creater;
	@ApiModelProperty(value = "갱신일")
	private Date updateDate;
	@ApiModelProperty(value = "갱신자")
	private String updater;
	@ApiModelProperty(value = "문자열 날짜")
	private String strDate;
	@ApiModelProperty(value = "닉네임")
	private String displayName;
	@ApiModelProperty(value = "댓글 카운트")
	private int commentNum;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getGroupIdx() {
		return groupIdx;
	}
	public void setGroupIdx(int groupIdx) {
		this.groupIdx = groupIdx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getProductNameKor() {
		return productNameKor;
	}
	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNoticeLink() {
		return noticeLink;
	}
	public void setNoticeLink(String noticeLink) {
		this.noticeLink = noticeLink;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getActivityAddrIdx() {
		return activityAddrIdx;
	}
	public void setActivityAddrIdx(int activityAddrIdx) {
		this.activityAddrIdx = activityAddrIdx;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public int getActivityFoodIdx() {
		return activityFoodIdx;
	}
	public void setActivityFoodIdx(int activityFoodIdx) {
		this.activityFoodIdx = activityFoodIdx;
	}
	public String getActivityGrade() {
		return activityGrade;
	}
	public void setActivityGrade(String activityGrade) {
		this.activityGrade = activityGrade;
	}
	public String getMediaFilename() {
		return mediaFilename;
	}
	public void setMediaFilename(String mediaFilename) {
		this.mediaFilename = mediaFilename;
	}
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
	public int getMpttLeft() {
		return mpttLeft;
	}
	public void setMpttLeft(int mpttLeft) {
		this.mpttLeft = mpttLeft;
	}
	public int getMpttRight() {
		return mpttRight;
	}
	public void setMpttRight(int mpttRight) {
		this.mpttRight = mpttRight;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public Boolean getLikeFlg() {
		return likeFlg;
	}
	public void setLikeFlg(Boolean likeFlg) {
		this.likeFlg = likeFlg;
	}
	public Boolean getActivityDelFlg() {
		return activityDelFlg;
	}
	public void setActivityDelFlg(Boolean activityDelFlg) {
		this.activityDelFlg = activityDelFlg;
	}
	public Boolean getActivityHiddenFlg() {
		return activityHiddenFlg;
	}
	public void setActivityHiddenFlg(Boolean activityHiddenFlg) {
		this.activityHiddenFlg = activityHiddenFlg;
	}
	public String getActivityHiddenImg() {
		return activityHiddenImg;
	}
	public void setActivityHiddenImg(String activityHiddenImg) {
		this.activityHiddenImg = activityHiddenImg;
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
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
}