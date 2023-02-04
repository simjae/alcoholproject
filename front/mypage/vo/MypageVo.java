package com.bvdev.alcoholproject.front.mypage.vo;

import java.util.List;

import com.bvdev.alcoholproject.api.dto.BadgeDto;
import com.bvdev.alcoholproject.api.dto.MypageDto;

public class MypageVo {
	MypageDto mypageDto;
	List<BadgeDto> badgeDtoList;
	
	public MypageDto getMypageDto() {
		return mypageDto;
	}
	public void setMypageDto(MypageDto mypageDto) {
		this.mypageDto = mypageDto;
	}
	public List<BadgeDto> getBadgeDtoList() {
		return badgeDtoList;
	}
	public void setBadgeDtoList(List<BadgeDto> badgeDtoList) {
		this.badgeDtoList = badgeDtoList;
	}
}