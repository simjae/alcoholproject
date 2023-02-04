package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.BadgeDto;
import com.bvdev.alcoholproject.api.dto.MemberAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.MemberDto;
import com.bvdev.alcoholproject.api.dto.MypageDto;

@Repository
public class ApiMemberDao {
	
	//TBL_MEMBER
	private static final String INSERT_TBL_MEMBER = "member.insertTblMember";
	private static final String UPDATE_TBL_MEMBER_BY_IDX = "member.updateTblMemberByIdx";
	private static final String SELECT_TBL_MEMBER_BY_IDX = "member.selectTblMemberByIdx";
	private static final String DELETE_TBL_MEMBER_BY_IDX = "member.deleteTblMemberByIdx";

	//TBL_MEMBER - MYPAGE
	private static final String SELECT_MYPAGE_INFO_BY_IDX = "member.selectMyPageInfoByIdx";
	private static final String SELECT_MEMBER_BADGE_LIST = "member.selectMemberBadgeList";
	private static final String SELECT_TBL_MEMBER_IDX_BY_ID = "member.selectTblMemberIdxById";
	
	//TBL_MEMBER - RECENT MEMBER
	private static final String SELECT_RECENT_MENTION_MEMBER_BY_MEMBER_IDX = "selectRecentMentionMemberByMemberIdx";
	private static final String SELECT_MENTION_MEMBER_BY_MEMBER_ID_LIST = "selectMentionMemberByMemberIdList";
	
	//TBL_MEMBER - MESSEGE
	private static final String SELECT_TBL_MEMBER_BY_IDX_AND_DEL_FLG = "member.selectTblMemberByIdxAndDelFlg";

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//TBL_MEMBER
	public int insertTblMember(MemberDto memberDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_MEMBER,memberDto);
		int memberIdx = -1;
		if(result > 0) {
			memberIdx = memberDto.getIdx();
		}
		return memberIdx;
	}
	public int updateTblMemberByIdx(MemberDto memberDto) throws Exception {
		return sqlSession.update(UPDATE_TBL_MEMBER_BY_IDX, memberDto);
	}
	
	public int mergeTblMember(MemberDto memberDto) throws Exception {
		if(memberDto.getIdx() > 0) {
			return updateTblMemberByIdx(memberDto);
		}
		else {
			return insertTblMember(memberDto);
		}
	}
	
	public MemberDto selectTblMemberByIdx(int memberIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_MEMBER_BY_IDX,memberIdx);
	}
		
	public void deleteTblMemberByIdx(int memberIdx) throws Exception {
		sqlSession.update(DELETE_TBL_MEMBER_BY_IDX, memberIdx);
	}
	
	//TBL_MEMBER - MYPAGE
	public MypageDto selectMyPageInfoByIdx(int memberIdx) {
		return sqlSession.selectOne(SELECT_MYPAGE_INFO_BY_IDX, memberIdx);
	}
	
	public List<BadgeDto> selectMemberBadgeList(int memberIdx) {
		return sqlSession.selectList(SELECT_MEMBER_BADGE_LIST,memberIdx);
	}
	
	public int selectTblMemberIdxById(String memberId) {
		int result = sqlSession.selectOne(SELECT_TBL_MEMBER_IDX_BY_ID,memberId);
		
		int memberIdx = -1;
		if (result > 0) {
			memberIdx = result;
		}
		
		return memberIdx;
	}
	
	public List<MemberAutoCompleteDto> selectRecentMentionMemberByMemberIdx(int memberIdx) throws Exception {
		List<MemberAutoCompleteDto> memberAutoCompleteDtoList = sqlSession.selectList(SELECT_RECENT_MENTION_MEMBER_BY_MEMBER_IDX,memberIdx);
		
		return memberAutoCompleteDtoList;
	}
	
	public List<MemberAutoCompleteDto> selectMentionMemberByMemberIdList(MemberAutoCompleteDto memberAutoCompleteDto) throws Exception {
		List<MemberAutoCompleteDto> memberAutoCompleteDtoList = sqlSession.selectList(SELECT_MENTION_MEMBER_BY_MEMBER_ID_LIST,memberAutoCompleteDto);
		
		return memberAutoCompleteDtoList;
	}
	
	public int selectTblMemberByIdxAndDelFlg(int memberIdx) {
		return sqlSession.selectOne(SELECT_TBL_MEMBER_BY_IDX_AND_DEL_FLG, memberIdx);
	}

}