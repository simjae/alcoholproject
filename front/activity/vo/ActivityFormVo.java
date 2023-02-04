package com.bvdev.alcoholproject.front.activity.vo;

import java.util.List;

import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.MediaDto;
import com.bvdev.alcoholproject.api.dto.NotificationDto;

public class ActivityFormVo {
	private String memberId;
	private ActivityDto activityDto;
	private List<MediaDto> mediaDtoList;
	private String likeImg;
	private String activityFoodName;
	private List<NotificationDto> notificationDtoList;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public ActivityDto getActivityDto() {
		return activityDto;
	}
	public void setActivityDto(ActivityDto activityDto) {
		this.activityDto = activityDto;
	}
	public List<MediaDto> getMediaDtoList() {
		return mediaDtoList;
	}
	public void setMediaDtoList(List<MediaDto> mediaDtoList) {
		this.mediaDtoList = mediaDtoList;
	}
	public String getLikeImg() {
		return likeImg;
	}
	public void setLikeImg(String likeImg) {
		this.likeImg = likeImg;
	}
	public String getActivityFoodName() {
		return activityFoodName;
	}
	public void setActivityFoodName(String activityFoodName) {
		this.activityFoodName = activityFoodName;
	}
	public List<NotificationDto> getNotificationDtoList() {
		return notificationDtoList;
	}
	public void setNotificationDtoList(List<NotificationDto> notificationDtoList) {
		this.notificationDtoList = notificationDtoList;
	}
}