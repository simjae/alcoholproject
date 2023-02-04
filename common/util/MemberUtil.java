package com.bvdev.alcoholproject.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiMemberDao;

@Service
public class MemberUtil {

	@Autowired
	private ApiMemberDao apiMemberDao;
	
	public int getMemberIdx(String memberId) throws Exception {
		int memberIdx = apiMemberDao.selectTblMemberIdxById(memberId);
		return memberIdx;
	}
}