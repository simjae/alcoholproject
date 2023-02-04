package com.bvdev.alcoholproject.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.NotificationDto;

@Repository
public class ApiNotificationDao {
	
	//TBL_NOTIFICATION
	private static final String INSERT_TBL_NOTIFICATION = "notification.insertTblNotification";
	private static final String UPDATE_TBL_NOTIFICATION_CONFIRM_FLG_BY_IDX = "notification.updateTblNotificationConfirmFlgByIdx";
	private static final String DELETE_TBL_NOTIFICATION_BY_ACTIVITY_IDX = "notification.deleteTblNotificationByActivityIdx";
	private static final String SELECT_TBL_NOTIFICATION_CNT_BY_MEMBER_IDX = "notification.selectTblNotificationCntByMemberIdx";
	private static final String SELECT_TBL_NOTIFICATION_LIST_BY_ACTIVITY_IDX = "notification.selectTblNotificationListByActivityIdx";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertTblNotification(NotificationDto notificationDto) throws Exception {
		int result = sqlSession.insert(INSERT_TBL_NOTIFICATION, notificationDto);
		
		int notificationIdx = 0;
		if (result > 0) {
			notificationIdx = notificationDto.getIdx();
		}
		
		return notificationIdx;
	}
	
	public int updateTblNoticationConfirmFlgByIdx(NotificationDto notificationDto) throws Exception {
		return sqlSession.update(UPDATE_TBL_NOTIFICATION_CONFIRM_FLG_BY_IDX, notificationDto);
	}
	
	public void deleteTblNotificationByActivityIdx(int activityIdx) throws Exception {
		sqlSession.delete(DELETE_TBL_NOTIFICATION_BY_ACTIVITY_IDX, activityIdx);
	}
	
	public int mergeTblNotification(NotificationDto notificationDto) throws Exception {
		if(notificationDto.getIdx() > 0) {
			return insertTblNotification(notificationDto);
		}
		else {
			return updateTblNoticationConfirmFlgByIdx(notificationDto);
		}
	}

	public int selectTblNotificationCntByMemberIdx(int memberIdx) throws Exception {
		int result = sqlSession.selectOne(SELECT_TBL_NOTIFICATION_CNT_BY_MEMBER_IDX,memberIdx);
		
		int notificationCount = 0;
		if (result > 0) {
			notificationCount = result;
		}
		
		return notificationCount;
	}
	
	public List<NotificationDto> selectTblNotificationListByActivityIdx(int activityIdx) throws Exception {
		List<NotificationDto> notificationDtoList = sqlSession.selectList(SELECT_TBL_NOTIFICATION_LIST_BY_ACTIVITY_IDX,activityIdx);
		return notificationDtoList;
	}
}