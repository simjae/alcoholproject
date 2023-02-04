package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ApiKeyDto;

@Repository
public class ApiDao {
	//API
	private static final String INSERT_TBL_API_KEY = "apiKey.insertTblApiKey";
	private static final String SELECT_TBL_API_KEY_LIST = "apiKey.selectTblApiKeyList";
	private static final String SELECT_TBL_API_KEY_BY_KEY_VALUE = "apiKey.selectTblApiKeyByKeyValue";
	private static final String SELECT_TBL_API_KEY_BY_ADMIN_KEY_VALUE = "apiKey.selectTblApiKeyByAdminKeyValue";
	
	private static final String SELECT_TBL_API_KEY_KEY_VALUE = "apiKey.selectTblApiKeyKeyValue";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//API
	public int insertTblApiKey(ApiKeyDto apikey) throws Exception {
		int resultCnt = 1;
		sqlSession.insert(INSERT_TBL_API_KEY, apikey);
		
		return resultCnt;
	}
	
	public List<ApiKeyDto> selectlTblApiKeyList() throws Exception {
		List<ApiKeyDto> apikeyDtoList = sqlSession.selectList(SELECT_TBL_API_KEY_LIST);
		return apikeyDtoList;
	}

	public List<ApiKeyDto> selectTblApiKeyByKeyValue(String header) throws Exception {
		List<ApiKeyDto> apikeyDtoList = sqlSession.selectList(SELECT_TBL_API_KEY_BY_KEY_VALUE, header);
		
		return apikeyDtoList;
	}
	
	public List<ApiKeyDto> selectTblApiKeyByAdminKeyValue(String header) throws Exception {
		List<ApiKeyDto> apikeyDtoList = sqlSession.selectList(SELECT_TBL_API_KEY_BY_ADMIN_KEY_VALUE, header);
		
		return apikeyDtoList;
	}
	
	public ApiKeyDto selectTblApiKeyKeyValue(String keyComment) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_API_KEY_KEY_VALUE,keyComment);
	}
}