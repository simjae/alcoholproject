package com.bvdev.alcoholproject.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.bvdev.alcoholproject.api.dto.MediaDto;

@Repository
public class ApiMediaDao {

	//TBL_MEDIA
	private static final String INSERT_TBL_MEDIA = "media.insertTblMedia";
	private static final String UPDATE_TBL_MEDIA = "media.updateTblMedia";
	private static final String DELETE_TBL_MEDIA_BY_ACTIVITY_IDX = "media.deleteTblMediaByActivityIdx";
	private static final String SELECT_TBL_MEDIA_LIST_BY_ACTIVITY_IDX = "media.selectTblMediaListByActivityIdx";
	private static final String SELECT_TBL_MEDIA_MEDIA_FILENAME_BY_IDX = "media.selectTblMediaMediaFilenameByIdx";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertTblMedia(MediaDto mediaDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_MEDIA,mediaDto);
		
		int mediaIdx = 0;
		if (result > 0) {
			mediaIdx = mediaDto.getIdx();
		}
		
		return mediaIdx;
	}
	
	public int updateTblMedia(MediaDto mediaDto) throws Exception {
		return sqlSession.update(UPDATE_TBL_MEDIA,mediaDto);
	}
	
	public int mergeTblMedia(MediaDto mediaDto) throws Exception {
		if(mediaDto.getIdx() > 0) {
			return updateTblMedia(mediaDto);
		}
		else {
			return insertTblMedia(mediaDto);
		}
	}
	
	public int deleteTblMediaByActivityIdx(MediaDto mediaDto) throws Exception {
		return sqlSession.update(DELETE_TBL_MEDIA_BY_ACTIVITY_IDX,mediaDto);
	}
	
	public List<MediaDto> selectTblMediaListByActivityIdx(int activityIdx) throws Exception {
		return sqlSession.selectList(SELECT_TBL_MEDIA_LIST_BY_ACTIVITY_IDX,activityIdx);
	}
	
	public String selectTblMediaMediaFilenameByIdx(int mediaIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_MEDIA_MEDIA_FILENAME_BY_IDX,mediaIdx);
	}
}