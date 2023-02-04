package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ActivityFoodDto;
import com.bvdev.alcoholproject.api.dto.FoodInfoDto;

@Repository
public class ApiActivityFoodDao {
	//TBL_ACTIVITY_FOOD
	private static final String SELECT_RECENT_ACTIVITY_FOOD_BY_MEMBER_IDX = "activity_food.selectRecentActivityFoodByMemberIdx";
	private static final String SELECT_TBL_ACTIVITY_FOOD_BY_IDX = "activity_food.selectTblActivityFoodByIdx";
	private static final String INSERT_TBL_ACTIVITY_FOOD = "activity_food.insertTblActivityFood";
	private static final String DELETE_TBL_ACTIVITY_FOOD_BY_IDX = "activity_food.deleteTblActivityFoodByIdx";
	
	//TBL_FOOD_INFO
	private static final String SELECT_TBL_FOOD_INFO_LIST_BY_ACTIVITY_IDX = "activity_food.selectTblFoodInfoListByActivityIdx";
	private static final String SELECT_TBL_FOOD_INFO_LIST_BY_IDX = "activity_food.selectTblFoodInfoListByIdx";
	private static final String SELECT_TBL_FOOD_INFO_CNT_BY_FOOD_NAME = "activity_food.selectTblFoodInfoCntByFoodName"; 
	private static final String INSERT_TBL_FOOD_INFO = "activity_food.insertTblFoodInfo";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<FoodInfoDto> selectRecentActivityFoodByMemberIdx(int memberIdx) throws Exception {
		return sqlSession.selectList(SELECT_RECENT_ACTIVITY_FOOD_BY_MEMBER_IDX,memberIdx);
	}
	
	public ActivityFoodDto selectTblActivityFoodByIdx(int activityFoodIdx) throws Exception {
		return sqlSession.selectOne(SELECT_TBL_ACTIVITY_FOOD_BY_IDX,activityFoodIdx);
	}
	
	public int insertTblActivityFood(ActivityFoodDto activityFoodDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_FOOD,activityFoodDto);
		
		int activityFoodIdx = -1;
		if (result > 0) {
			activityFoodIdx = activityFoodDto.getIdx();
		}
		
		return activityFoodIdx;
	}
	
	public int deleteTblActivityFoodByIdx(int activityIdx) throws Exception {
		return sqlSession.update(DELETE_TBL_ACTIVITY_FOOD_BY_IDX,activityIdx);
	}
	
	public List<FoodInfoDto> selectTblFoodInfoListByActivityIdx(int activityIdx) throws Exception {
		return sqlSession.selectList(SELECT_TBL_FOOD_INFO_LIST_BY_ACTIVITY_IDX,activityIdx);
	}
	
	public List<FoodInfoDto> selectTblFoodInfoListByIdx(List<Integer> foodInfoIdxList) throws Exception {
		return sqlSession.selectList(SELECT_TBL_FOOD_INFO_LIST_BY_IDX,foodInfoIdxList);
	}
	
	public int selectTblFoodInfoCntByFoodName(String foodName) throws Exception {
		int result = sqlSession.selectOne(SELECT_TBL_FOOD_INFO_CNT_BY_FOOD_NAME,foodName);
		
		int foodCnt = -1;
		if (result > 0) {
			foodCnt = result;
		}
		
		return foodCnt;
	}
	
	public int insertTblFoodInfo(FoodInfoDto foodInfoDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_FOOD_INFO,foodInfoDto);
		
		int foodInfoIdx = -1;
		if (result > 0) {
			foodInfoIdx = foodInfoDto.getIdx();
		}
		
		return foodInfoIdx;
	}
}