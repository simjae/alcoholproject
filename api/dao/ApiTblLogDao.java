package com.bvdev.alcoholproject.api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.ActivityAddrLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityFoodLogDto;
import com.bvdev.alcoholproject.api.dto.ActivityProductLogDto;
import com.bvdev.alcoholproject.api.dto.NotificationLogDto;

@Repository
public class ApiTblLogDao {
	//TBL_ACTIVITY_PRODUCT_LOG
	private static final String INSERT_TBL_ACTIVITY_PRODUCT_LOG = "tbl_log.insertTblActivityProductLog";
	private static final String DELETE_TBL_ACTIVITY_PRODUCT_LOG = "tbl_log.deleteTblActivityProductLog";
		
	//TBL_ACTIVITY_ADDR_LOG
	private static final String INSERT_TBL_ACTIVITY_ADDR_LOG = "tbl_log.insertTblActivityAddrLog";
	private static final String DELETE_TBL_ACTIVITY_ADDR_LOG = "tbl_log.deleteTblActivityAddrLog";

	//TBL_ACTIVITY_FOOD_LOG
	private static final String INSERT_TBL_ACTIVITY_FOOD_LOG = "tbl_log.insertTblActivityFoodLog";
	private static final String DELETE_TBL_ACTIVITY_FOOD_LOG = "tbl_log.deleteTblActivityFoodLog";
	
	//TBL_NOTIFICATION_LOG
	private static final String INSERT_TBL_NOTIFICATION_LOG = "tbl_log.insertTblNotificationLog";
	private static final String DELETE_TBL_NOTIFICATION_LOG_BY_MEMBER_IDX = "tbl_log.deleteTblNotificationLogByMemberIdx";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertTblActivityProductLog(ActivityProductLogDto activityProductLogDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_PRODUCT_LOG, activityProductLogDto);
		
		int activityAddrLogIdx = -1;
		if (result > 0) {
			activityAddrLogIdx = activityProductLogDto.getIdx();
		}
		
		return activityAddrLogIdx;
	}
	
	public int deleteTblActivityProductLog(ActivityProductLogDto activityProductLogDto) throws Exception {
		return sqlSession.delete(DELETE_TBL_ACTIVITY_PRODUCT_LOG,activityProductLogDto);
	}

	public int insertTblActivityAddrLog(ActivityAddrLogDto activityAddrLogDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_ADDR_LOG, activityAddrLogDto);
		
		int activityAddrLogIdx = -1;
		if (result > 0) {
			activityAddrLogIdx = activityAddrLogDto.getIdx();
		}
		
		return activityAddrLogIdx;
	}
	
	public int deleteTblActivityAddrLog(ActivityAddrLogDto activityAddrLogDto) throws Exception {
		return sqlSession.delete(DELETE_TBL_ACTIVITY_ADDR_LOG,activityAddrLogDto);
	}
	
	public int insertTblActivityFoodLog(ActivityFoodLogDto activityFoodLogDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_ACTIVITY_FOOD_LOG,activityFoodLogDto);
		
		int activityFoodLogIdx = -1;
		if (result > 0) {
			activityFoodLogIdx = activityFoodLogDto.getIdx();
		}
		
		return activityFoodLogIdx;
	}
	
	public int deleteTblActivityFoodLog(ActivityFoodLogDto activityFoodLogDto) throws Exception {
		return sqlSession.delete(DELETE_TBL_ACTIVITY_FOOD_LOG,activityFoodLogDto);
	}

	public int insertTblNotificationLog(NotificationLogDto notificationLogDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_NOTIFICATION_LOG,notificationLogDto);
		
		int notificationLogIdx = -1;
		if (result > 0) {
			notificationLogIdx = result;
		}
		
		return notificationLogIdx;
	}
	
	public int deleteTblNotificationLogByMemberIdx(NotificationLogDto notificationLogDto) throws Exception {
		return sqlSession.delete(DELETE_TBL_NOTIFICATION_LOG_BY_MEMBER_IDX,notificationLogDto);
	}
}