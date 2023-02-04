package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ProductActivityDto;
import com.bvdev.alcoholproject.api.dto.ProductReplyDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductKeywordDto;
import com.bvdev.alcoholproject.api.dto.ProductLikeDto;
import com.bvdev.alcoholproject.api.dto.ProductParamDto;
import com.bvdev.alcoholproject.api.dto.ProductRecommendDto;
import com.bvdev.alcoholproject.api.dto.ProductShopInfoDto;

@Repository
public class ApiProductDao {
	//TBL_PRODUCT
	private static final String SELECT_TBL_PRODUCT_BY_IDX = "product.selectTblProductByIdx";
	private static final String SELECT_TBL_PRODUCT_KEYWORD_LIST_BY_PRODUCT_IDX = "product.selectTblProductKeywordListByProductIdx";
	private static final String SELECT_PRODUCT_ACTIVITY_LIST = "product.selectProductActivityList";
	private static final String SELECT_PRODUCT_REPLY_LIST = "product.selectProductReplyList";
	private static final String SELECT_PRODUCT_SHOP_INFO_LIST = "product.selectProductShopInfoList";
	private static final String SELECT_PRODUCT_RECOMMEND_LIST = "product.selectProductRecommendList";
	private static final String UPDATE_TBL_PRODUCT_BY_IDX = "product.updateTblProductByIdx";
	private static final String SELECT_TBL_PRODUCT_LIKE_NUM_BY_IDX = "product.selectTblProductLikeNumByIdx";
	
	//TBL_PRODUCT_LIKE
	private static final String INSERT_TBL_PRODUCT_LIKE = "product.insertTblProductLike";
	private static final String DELETE_TBL_PRODUCT_LIKE = "product.deleteTblProductLike";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ProductDto selectTblProductByIdx(ProductParamDto productParamDto) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_PRODUCT_BY_IDX,productParamDto);
	}
	
	public List<ProductKeywordDto> selectTblProductKeywordListByProductIdx(int productIdx) throws Exception {
		return sqlSession.selectList(SELECT_TBL_PRODUCT_KEYWORD_LIST_BY_PRODUCT_IDX,productIdx);
	}
	
	public List<ProductActivityDto> selectProductActivityList(ProductParamDto productParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_ACTIVITY_LIST,productParamDto);
	}
	
	public List<ProductReplyDto> selectProductReplyList(int productIdx) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_REPLY_LIST,productIdx);
	}
	
	public List<ProductShopInfoDto> selectProductShopInfoList(ProductParamDto productParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_SHOP_INFO_LIST,productParamDto);
	}
	
	public List<ProductRecommendDto> selectProductRecommendList(ProductParamDto productParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_RECOMMEND_LIST,productParamDto);
	}
	
	public int updateTblProductByIdx(ProductDto productDto) throws Exception {
		int result = sqlSession.update(UPDATE_TBL_PRODUCT_BY_IDX,productDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}
	
	public int selectTblProductLikeNumByIdx(int productIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_PRODUCT_LIKE_NUM_BY_IDX,productIdx);
	}
	
	public int insertTblProductLike(ProductLikeDto productLikeDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_PRODUCT_LIKE,productLikeDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}
	
	public int deleteTblProductLike(ProductLikeDto productLikeDto) throws Exception {
		int result =  sqlSession.delete(DELETE_TBL_PRODUCT_LIKE,productLikeDto);
		
		int resultCnt = -1;
		if (result > 0) {
			resultCnt = result;
		}
		
		return resultCnt;
	}
}