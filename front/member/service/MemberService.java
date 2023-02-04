package com.bvdev.alcoholproject.front.member.service;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiMemberDao;
import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.BadgeDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.api.dto.MypageDto;
import com.bvdev.alcoholproject.common.util.HashUtil;
import com.bvdev.alcoholproject.common.util.MessageUtils;

@Service
public class MemberService {

	@Inject
	private ApiMemberDao apiMemberDao;
	
	@Inject
	private ApiActivityDao apiActivityDao;
	
	public int insertTblMember(MemberDto memberDto) throws Exception {
		
		int errCnt = 0;

		// 예외처리 : PARAM - MEMBERDTO
		if (memberDto == null) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.MEMBERDTO"});			
		}

		// 예외처리 : PARAM - ID		
		if (memberDto.getId() == null || memberDto.getId().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.ID"});
		}
		
		// 예외처리 : PARAM - PASSWORD
		if (memberDto.getPassword() == null || memberDto.getPassword().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.PASSWORD"});
		} else {
			String password = memberDto.getPassword();
			password = HashUtil.encoding(password);
			
			memberDto.setPassword(password);
		}
		
		// 예외처리 : PARAM - NAME
		if (memberDto.getName() == null || memberDto.getName().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.NAME"});
		}
		
		// 예외처리 : PARAM - DISPLAY_NAME
		if (memberDto.getDisplayName() == null || memberDto.getDisplayName().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.DISPLAY_NAME"});
		}
		
		// 예외처리 : PARAM - EMAIL
		if (memberDto.getEmail() == null || memberDto.getEmail().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.EMAIL"});
		} else {
			String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
			
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(memberDto.getEmail());
			boolean isMail = m.matches();
			if (isMail == false) {
				throw new Exception(MessageUtils.getMessage("S_ERR_0003", new String[] { "PARAM.EMAIL" }));
			}
		}
		
		// 예외처리 : PARAM - MOBILE
		if (memberDto.getMobile() == null || memberDto.getMobile().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.MOBILE"});
		}
		
		// 예외처리 : PARAM - GENDER
		if (memberDto.getGender() == null || memberDto.getGender().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.GENDER"});
		}

		// 예외처리 : PARAM - BIRTH
		if (memberDto.getBirth() == null || memberDto.getBirth().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.BIRTH"});
		}
		
		// 예외처리 : PARAM - PUSH_YN
		if (memberDto.getPushYn() == null) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.PUSH_YN"});
		}
		
		// 예외처리 : PARAM - REG IP
		String localIp = null;
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
			
			if (local != null) {
				localIp = local.getHostAddress();
			}
			
			memberDto.setRegIp(localIp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int memberIdx = 0;
		try {
			if (errCnt == 0) {
				memberIdx = apiMemberDao.insertTblMember(memberDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberIdx;
	}
	
	public MemberDto selectTblMemberByIdx(int memberIdx) throws Exception {
		
		int errCnt = 0;
		
		// 예외처리 : PARAM - MEMBER_IDX
		if (memberIdx < 0 || memberIdx == 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		MemberDto memberDto = new MemberDto();
		if (errCnt == 0) {
			try {
				memberDto = apiMemberDao.selectTblMemberByIdx(memberIdx); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return memberDto;
	}
	
	public void updateTblMemberByIdx(MemberDto memberDto) throws Exception {
		
		int errCnt = 0;

		// 예외처리 : PARAM - MEMBERDTO
		if (memberDto == null) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.MEMBERDTO"});			
		}
		
		// 예외처리 : PARAM - MEMBER_IDX
		if (memberDto.getIdx() < 0 || memberDto.getIdx() == 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		// 예외처리 : PARAM - PASSWORD
		if (memberDto.getPassword() == null || memberDto.getPassword().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.PASSWORD"});
		} else {
			String password = memberDto.getPassword();
			password = HashUtil.encoding(password);
			
			memberDto.setPassword(password);
		}
		
		// 예외처리 : PARAM - DISPLAY_NAME
		if (memberDto.getDisplayName() == null || memberDto.getDisplayName().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.DISPLAY_NAME"});
		}
		
		// 예외처리 : PARAM - EMAIL
		if (memberDto.getEmail() == null || memberDto.getEmail().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.EMAIL"});
		} else {
			String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
			
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(memberDto.getEmail());
			boolean isMail = m.matches();
			if (isMail == false) {
				throw new Exception(MessageUtils.getMessage("S_ERR_0004", new String[] { "PARAM.EMAIL" }));
			}
		}
		
		// 예외처리 : PARAM - MOBILE
		if (memberDto.getMobile() == null || memberDto.getMobile().isEmpty()) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.MOBILE"});
		}
		
		// 예외처리 : PARAM - PUSH_YN
		if (memberDto.getPushYn() == null) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0001",new String[] {"PARAM.PUSH_YN"});
		}
		
		try {
			if (errCnt == 0) {
				apiMemberDao.updateTblMemberByIdx(memberDto);
				
				ActivityDto activityDto = new ActivityDto();
				activityDto.setGroupIdx(0);
				activityDto.setMemberIdx(memberDto.getIdx());
				activityDto.setType("member");
				activityDto.setAction("member_update");
				activityDto.setNoticeLink("");
				activityDto.setContent("");
				activityDto.setPrimaryIdx(0);
				activityDto.setSecondaryIdx(0);
				activityDto.setMpttLeft(0);
				activityDto.setMpttRight(0);
				activityDto.setCreater(memberDto.getId());
				activityDto.setUpdater(memberDto.getId());
				
				apiActivityDao.insertTblActivity(activityDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTblMemberByIdx(int memberIdx) throws Exception {
		
		int errCnt = 0;
		
		// 예외처리 : PARAM - IDX
		if (memberIdx == 0 || memberIdx < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		try {
			if (errCnt == 0) {
				apiMemberDao.deleteTblMemberByIdx(memberIdx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MypageDto selectMyPageInfoByIdx(int memberIdx) {
		
		int errCnt = 0;
		
		// 예외처리 : PARAM - IDX
		if (memberIdx == 0 || memberIdx < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		MypageDto myPageDto = new MypageDto();
		
		try {
			if (errCnt == 0) {
				myPageDto = apiMemberDao.selectMyPageInfoByIdx(memberIdx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myPageDto;
	}
	
	public List<BadgeDto> selectMemberBadgeList(int memberIdx) throws Exception {
		
		int errCnt = 0;
		
		// 예외처리 : PARAM - IDX
		if (memberIdx == 0 || memberIdx < 0) {
			errCnt++;
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.MEMBER_IDX"});
		}
		
		List<BadgeDto> badgeDtoList = new ArrayList<BadgeDto>();
		
		try {
			if (errCnt == 0) {
				badgeDtoList = apiMemberDao.selectMemberBadgeList(memberIdx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return badgeDtoList;
		
	}
}