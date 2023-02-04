package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ProductDto;

@Repository
public class ApiActivityProductDao {
	//TBL_ACTIVITY_ADDR
	private static final String SELECT_RECENT_ACTIVITY_PRODUCT_BY_MEMBER_IDX = "activity_product.selectRecentActivityProductByMemberIdx";
	private static final String SELECT_ACTIVITY_PRODUCT_BY_IDX = "activity_product.selectActivityProductByIdx";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ProductDto> selectRecentActivityProductByMemberIdx(int memberIdx) throws Exception {
		return sqlSession.selectList(SELECT_RECENT_ACTIVITY_PRODUCT_BY_MEMBER_IDX,memberIdx);
	}
	
	public ProductDto selectActivityProductByIdx(int productIdx) throws Exception {
		return sqlSession.selectOne(SELECT_ACTIVITY_PRODUCT_BY_IDX,productIdx);
	}
}