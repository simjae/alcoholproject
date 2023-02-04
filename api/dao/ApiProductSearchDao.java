package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ProductSearchParamDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductFilterDto;

@Repository
public class ApiProductSearchDao {
	
	private static final String SELECT_PRODUCT_CATEGORY_FILTER_LIST = "search.selectProductCategoryFilterList";
	private static final String SELECT_PRODUCT_AROMA_FILTER_LIST = "search.selectProductAromaFilterList";
	private static final String SELECT_PRODUCT_COUNTRY_FILTER_LIST = "search.selectProductCountryFilterList";
	
	private static final String SELECT_PRODUCT_SEARCH_RESULT_LIST = "search.selectProductSearchResultList";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ProductFilterDto> selectProductCategoryFilterList(ProductSearchParamDto productSearchParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_CATEGORY_FILTER_LIST,productSearchParamDto);
	}
	
	public List<ProductFilterDto> selectProductAromaFilterList(ProductSearchParamDto productSearchParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_AROMA_FILTER_LIST,productSearchParamDto);
	}
	
	public List<String> selectProductCountryFilterList(ProductSearchParamDto productSearchParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_COUNTRY_FILTER_LIST,productSearchParamDto);
	}
	
	public List<ProductDto> selectProductSearchResultList(ProductSearchParamDto productSearchParamDto) throws Exception {
		return sqlSession.selectList(SELECT_PRODUCT_SEARCH_RESULT_LIST, productSearchParamDto);
	}
}