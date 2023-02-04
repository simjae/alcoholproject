package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ActivityDto;
import com.bvdev.alcoholproject.api.dto.ReplyDto;

@Repository
public class ApiReplyDao {
	
	//TBL_ACTIVITY REPLY
	private static final String SELECT_TBL_ACTIVITY_MAX_CHILD_MPTT_BY_IDX = "reply.selectTblActivityMaxChildMpttByIdx";
	private static final String UPDATE_TBL_ACTIVITY_MPTT_BY_IDX = "reply.updateTblActivityMpttByIdx";
	private static final String UPDATE_TBL_ACTIVITY_MPTT = "reply.updateTblActivityMptt";
	private static final String SELECT_TBL_ACTIVITY_BY_PRIMARY_IDX = "reply.selectTblActivityByPrimaryIdx";
	
	private static final String SELECT_REPLY_COMMENT_CNT_BY_ACTIVITY_IDX = "reply.selectReplyCommentCntByActivityIdx";
	private static final String SELECT_REPLY_INFO = "reply.selectReplyInfo";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int selectTblActivityMaxChildMpttByIdx(int activityIdx) throws Exception {	
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_MAX_CHILD_MPTT_BY_IDX, activityIdx);
	}
	
	public int updateTblActivityMpttByIdx(int activityIdx) throws Exception {
		int result = sqlSession.update(UPDATE_TBL_ACTIVITY_MPTT_BY_IDX, activityIdx);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}

	public int updateTblActivityMptt(ActivityDto activityDto) throws Exception {
		int result = sqlSession.update(UPDATE_TBL_ACTIVITY_MPTT, activityDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}

	public List<Integer> selectTblActivityByPrimaryIdx(ActivityDto activityDto) throws Exception {
		return sqlSession.selectList(SELECT_TBL_ACTIVITY_BY_PRIMARY_IDX, activityDto);
	}	
	
	public int selectReplyCommentCntByActivityIdx(int activityIdx) throws Exception {
		return sqlSession.selectOne(SELECT_REPLY_COMMENT_CNT_BY_ACTIVITY_IDX,activityIdx);
	}
	
	public ReplyDto selectReplyInfo(ReplyDto replyDto) throws Exception {
		return sqlSession.selectOne(SELECT_REPLY_INFO,replyDto);
	}
	
	public List<ReplyDto> selectReplyInfoList(ReplyDto replyDto) throws Exception {
		return sqlSession.selectList(SELECT_REPLY_INFO,replyDto);
	}
}