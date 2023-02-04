package com.bvdev.alcoholproject.front.member.service;

import java.net.InetAddress;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiLoginDao;
import com.bvdev.alcoholproject.api.dto.LoginDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.common.util.HashUtil;
import com.bvdev.alcoholproject.common.util.MessageUtils;

@Service
public class LoginService {

	@Inject
	private ApiLoginDao apiLoginDao;

	public MemberDto getLogin(LoginDto loginDto) throws Exception {
		
		if (loginDto == null) {
			//exception 발생 주석처리
			//throw new Exception(MessageUtils.getMessage("S_ERR_0001", new String[] { "userRegistDto" }));
			MessageUtils.getMessage("S_ERR_0001", new String[] { "userRegistDto" });
		}
		
		//	예외처리 : PARAM - ID 
		if (loginDto.getId() == null || loginDto.getId().isEmpty()) {
			//throw new Exception(MessageUtils.getMessage("S_ERR_0001", new String[] { "PARAM.ID" }));
			MessageUtils.getMessage("S_ERR_0001", new String[] { "PARAM.ID" });
		}

		//	예외처리 : PARAM - PASSWORD
		if (loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
			//throw new Exception(MessageUtils.getMessage("S_ERR_0001", new String[] { "PARAM.PASSWORD" }));
			MessageUtils.getMessage("S_ERR_0001", new String[] { "PARAM.PASSWORD" });
		} else {
			String password = loginDto.getPassword();
			password = HashUtil.encoding(password);
			loginDto.setPassword(password);
		}
		
		MemberDto memberDto = apiLoginDao.selectTblMemberByLoginDto(loginDto);
		
		if (memberDto != null) {
			String loginIp = memberDto.getLoginIp();
			String localIp = null;
			InetAddress local = null;
			try {
				local = InetAddress.getLocalHost();
				
				if (local != null) {
					localIp = local.getHostAddress();
				}
				
				if (loginIp == null || loginIp != localIp) {
					memberDto.setLoginIp(localIp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int loginCnt = memberDto.getLoginCnt();
			loginCnt++;
			memberDto.setLoginCnt(loginCnt);
			
			apiLoginDao.updateTblMemberLoginIpByIdx(memberDto);
		}

		return memberDto;
	}
}