package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ActivityAddrDto;

@Repository
public class ApiActivityAddrDao {
	//TBL_ACTIVITY_ADDR
	private static final String SELECT_RECENT_ACTIVITY_ADDR_BY_MEMBER_IDX = "activity_addr.selectRecentActivityAddrByMemberIdx";
	private static final String SELECT_TBL_ACTIVITY_ADDR_BY_IDX = "activity_addr.selectTblActivityAddrByIdx";
	private static final String INSERT_TBL_ACTIVITY_ADDR = "activity_addr.insertTblActivityAddr";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ActivityAddrDto> selectRecentActivityAddrByMemberIdx(int memberIdx) throws Exception {
		return sqlSession.selectList(SELECT_RECENT_ACTIVITY_ADDR_BY_MEMBER_IDX,memberIdx);
	}
	
	public ActivityAddrDto selectTblActivityAddrByIdx(int activityAddrIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_ADDR_BY_IDX,activityAddrIdx);
	}
	
	public int insertTblActivityAddr(ActivityAddrDto activityAddrDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_ADDR,activityAddrDto);
		
		int activityAddrIdx = -1;
		if (result > 0) {
			activityAddrIdx = activityAddrDto.getIdx();
		}
		
		return activityAddrIdx;
	}
}