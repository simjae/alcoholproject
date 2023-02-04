package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.AddrAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.FoodAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;
import com.bvdev.alcoholproject.api.dto.MemberAutoCompleteDto;
import com.bvdev.alcoholproject.api.dto.ProductAutoCompleteDto;

@Repository
public class ApiAutoCompleteDao {
	
	//TBL_PRODUCT AUTO COMPLETE
	private static final String SELECT_TBL_PRODUCT_BY_AUTO_COMPLETE = "autocomplete.selectTblProductByAutoComplete";

	//TBL_ACTIVITY_ADDR AUTO COMPLETE
	private static final String SELECT_TBL_ACTIVITY_ADDR_BY_AUTO_COMPLETE = "autocomplete.selectTblActivityAddrByAutoComplete";

	//TBL_FOOD_INFO AUTO COMPLETE
	private static final String SELECT_TBL_FOOD_INFO_BY_AUTO_COMPLETE = "autocomplete.selectTblFoodInfoByAutoComplete";
		
	//TBM_MEMBER - AUTO COMPLETE
	private static final String SELECT_TBL_MEMBER_BY_AUTO_COMPLETE = "autocomplete.selectTblMemberByAutoComplete";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//TBL_PRODUCT - PRODUCT NAME AUTOCOMPLETE
	public List<ProductAutoCompleteDto> selectTblProductByAutoComplete(String keyword) throws Exception {
		return sqlSession.selectList(SELECT_TBL_PRODUCT_BY_AUTO_COMPLETE,keyword);
	}
	
	//TBL_ACTIVITY_ADDR - ADDR NAME AUTOCOMPLETE
	public List<AddrAutoCompleteDto> selectTblActivityAddrByAutoComplete(String keyword) throws Exception {
		return sqlSession.selectList(SELECT_TBL_ACTIVITY_ADDR_BY_AUTO_COMPLETE,keyword);
	}

	//TBL_ACTIVITY_FOOD - FOOD NAME AUTOCOMPLETE
	public List<FoodInfoDto> selectTblFoodInfoByAutoComplete(FoodAutoCompleteDto foodAutoCompleteDto) throws Exception {
		return sqlSession.selectList(SELECT_TBL_FOOD_INFO_BY_AUTO_COMPLETE,foodAutoCompleteDto);
	}
	
	//TBL_MEMBER - MENTION MEMBER AUTOCOMPLETE
	public List<MemberAutoCompleteDto> selectTblMemberByAutoComplete(MemberAutoCompleteDto memberAutoCompleteDto) {
		List<MemberAutoCompleteDto> result = sqlSession.selectList(SELECT_TBL_MEMBER_BY_AUTO_COMPLETE,memberAutoCompleteDto);
		return result;
	}
}