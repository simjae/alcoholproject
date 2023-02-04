package com.bvdev.alcoholproject.api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.LoginDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;

@Repository
public class ApiLoginDao {

	// TBL_MEMBER - LOGIN
	private static final String SELECT_TBL_MEMBER_BY_LOGIN_DTO = "login.selectTblMemberByLoginDto";
	private static final String UPDATE_TBL_MEMBER_LOGIN_INFO = "login.updateTblMemberLoginInfo";

	@Autowired
	private SqlSessionTemplate sqlSession;

	// TBL_MEMBER - LOGIN
	public MemberDto selectTblMemberByLoginDto(LoginDto loginDto) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_MEMBER_BY_LOGIN_DTO, loginDto);
	}

	public void updateTblMemberLoginIpByIdx(MemberDto memberDto) throws Exception {
		sqlSession.update(UPDATE_TBL_MEMBER_LOGIN_INFO, memberDto);
	}

}
