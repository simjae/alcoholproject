package com.bvdev.alcoholproject.api.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.ActivityParamDto;
import com.bvdev.alcoholproject.api.dto.ActivityScoreDto;

@Repository
public class ApiActivityDao {
	//TBL_ACTIVITY
	private static final String INSERT_TBL_ACTIVITY = "activity.insertTblActivity";
	private static final String UPDATE_TBL_ACTIVITY_BY_IDX = "activity.updateTblActivityByIdx";
	private static final String SELECT_TBL_ACTIVITY_HIDDEN_IMG_BY_IDX = "activity.selectTblActivityHiddenImgByIdx";
	private static final String SELECT_TBL_ACTIVITY_BY_IDX = "activity.selectTblActivityByIdx";
	private static final String SELECT_TBL_ACTIVITY_LIST = "activity.selectTblActivityList";
	private static final String SELECT_TBL_MEDIA_BY_MEMBER_ACTIVITY_IDX = "activity.selectTblMediaByMemberActivityIdx";
	private static final String UPDATE_TBL_ACTIVITY_LIKE_NUM_BY_IDX = "activity.updateTblActivityLikeNumByIdx";
	private static final String SELECT_TBL_ACTIVITY_LIKE_NUM_BY_IDX = "activity.selectTblActivityLikeNumByIdx";
	
	//TBL_ACTIVITY_SCORE
	private static final String INSERT_TBL_ACTIVITY_SCORE = "activity.insertTblActivityScore";
	private static final String DELETE_TBL_ACTIVITY_SCORE = "activity.deleteTblActivityScore";
	
	//TBL_ACTIVITY CALENDAR
	private static final String SELECT_TBL_ACTIVITY_BY_MONTH = "activity.selectTblActivityByMonth";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	 * TBL_ACTIVITY 
	 */
	public int insertTblActivity(ActivityDto activityDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY,activityDto);
		
		int activityIdx = -1;
		if(result > 0) {
			activityIdx = activityDto.getIdx();
		}
		
		return activityIdx; 
	}

	public int updateTblActivityByIdx(ActivityDto activityDto) throws Exception {
		int result = sqlSession.update(UPDATE_TBL_ACTIVITY_BY_IDX, activityDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}
	
	public int mergeTblActivity(ActivityDto activityDto) throws Exception {
		if(activityDto.getIdx() > 0) {
			return updateTblActivityByIdx(activityDto);
		}
		else {
			return insertTblActivity(activityDto);
		}
	}
	
	public String selectTblActivityHiddenInfoByActivityIdx(int activityIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_HIDDEN_IMG_BY_IDX,activityIdx);
	}
	
	public int updateTblActivityLikeNumByIdx(ActivityParamDto activityParamDto) throws Exception {
		int result = sqlSession.update(UPDATE_TBL_ACTIVITY_LIKE_NUM_BY_IDX,activityParamDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}
	
	public int selectTblActivityLikeNumByIdx(int activityIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_LIKE_NUM_BY_IDX,activityIdx);
	}
	
	public ActivityDto selectTblActivityByIdx(ActivityParamDto activityParamDto) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_BY_IDX,activityParamDto);
	}
	
	public List<ActivityDto> selectTblActivityList(ActivityParamDto activityParamDto) throws Exception {
		return sqlSession.selectList(SELECT_TBL_ACTIVITY_LIST,activityParamDto);
	}

	public List<ActivityDto> selectTblMediaByMemberActivityIdx(ActivityDto activityDto) throws Exception {
		return sqlSession.selectList(SELECT_TBL_MEDIA_BY_MEMBER_ACTIVITY_IDX, activityDto);
	}
	
	public int insertTblActivityScore(ActivityScoreDto activityScoreDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_SCORE,activityScoreDto);
		
		int activityScoreIdx = -1;
		if (result > 0) {
			activityScoreIdx = activityScoreDto.getIdx();
		}
		
		return activityScoreIdx;
	}
	
	public int deleteTblActivityScore(ActivityScoreDto activityScoreDto) throws Exception {
		int result = sqlSession.insert(DELETE_TBL_ACTIVITY_SCORE,activityScoreDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}

	public List<ActivityDto> selectTblActivityByMonth(Map<String, Object> paramMap) throws Exception {
		if(paramMap.size() != 0) {
			return sqlSession.selectList(SELECT_TBL_ACTIVITY_BY_MONTH,paramMap);
		}
		return null;
	}
}