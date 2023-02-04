package com.bvdev.alcoholproject.api.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bvdev.alcoholproject.api.dto.MessageDto;
import com.bvdev.alcoholproject.api.dto.AlarmDto;
import com.bvdev.alcoholproject.api.dto.MessageRecipientsDto;

@Repository
public class ApiMessageDao {
	
	//TBL_MESSAGE
	private static final String INSERT_TBL_MESSAGE = "message.insertTblMessage";
	private static final String UPDATE_TBL_MESSAGE = "message.updateTblMessage";
	private static final String INSERT_TBL_MESSAGE_RECIPIENTS = "message.insertTblMessageRecipients";
	private static final String SELECT_TBL_MESSAGE_RECIPIENTS_BY_SENDER_IDX = "message.selectTblMessageRecipientsBySenderIdx";
	private static final String SELECT_TBL_MESSAGE_BY_MESSAGE_GROUP_IDX = "message.selectTblMessageBymessageGroupIdx";
	private static final String SELECT_TBL_MESSAGE_RECIPIENTS_BY_IDX = "message.selectTblMessageRecipientsByIdx";
	private static final String UPDATE_TBL_MESSAGE_RECIPIENTS = "message.updateTblMessageRecipients";
	private static final String SELECT_TBL_MESSAGE_RECIPIENTS_BY_RECIEVER_IDX = "message.selectTblMessageRecipientsByRecieverIdx";
	private static final String SELECT_TBL_MESSAGE_BY_MEMBER_IDX = "message.selectTblMessageByMemberIdx";
	private static final String SELECT_NOW = "message.selectNow";
	private static final String SELECT_TBL_MESSAGE_RECIPIENTS_TO_UNREAD_COUNT = "message.selectTblMessageRecipientsToUnreadCount";
	
	private static final String SELECT_ACTIVITY_BY_SCORE_IDX = "message.selectActivityByScoreIdx";
	private static final String SELECT_ACTIVITY_BY_PRIMARY_IDX = "message.selectActivityByPrimaryIdx";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertTblMessage(MessageDto messageDto) throws Exception {
		int messageIdx = sqlSession.insert(INSERT_TBL_MESSAGE, messageDto);
		return messageIdx;
	}
	
	public int updateTblMessage(MessageDto messageDto) throws Exception {
		return sqlSession.update(UPDATE_TBL_MESSAGE, messageDto);
	}
	
	public int mergeTblMessage(MessageDto messageDto) throws Exception {
		if(messageDto.getIdx() > 0) {
			return updateTblMessage(messageDto);
		}
		else {
			return insertTblMessage(messageDto);
		}
	}
	
	public int insertTblMessageRecipients(Map<String, Object> messageRecipients) {
		return sqlSession.insert(INSERT_TBL_MESSAGE_RECIPIENTS, messageRecipients);
	}
	
	public Integer selectTblMessageRecipientsBySenderIdx(Map<String, Object> messageRecipients) {
		Integer result = sqlSession.selectOne(SELECT_TBL_MESSAGE_RECIPIENTS_BY_SENDER_IDX, messageRecipients);
		
		int messageIdx = -1;
		if (result != null && result > 0) {
			messageIdx = result;
		}
		return messageIdx;
	}
	
	public List<MessageDto> selectTblMessageBymessageGroupIdx(MessageDto messageDto){
		return sqlSession.selectList(SELECT_TBL_MESSAGE_BY_MESSAGE_GROUP_IDX, messageDto);
	}
	
	public Integer selectTblMessageRecipientsByIdx(int idx){
		return sqlSession.selectOne(SELECT_TBL_MESSAGE_RECIPIENTS_BY_IDX, idx);
	}

	public int updateTblMessageRecipients(MessageRecipientsDto messageRecipientsDto) {
		return sqlSession.update(UPDATE_TBL_MESSAGE_RECIPIENTS, messageRecipientsDto);
	}
	
	public int selectTblMessageRecipientsByRecieverIdx(MessageRecipientsDto messageRecipientsDto) {
		return sqlSession.selectOne(SELECT_TBL_MESSAGE_RECIPIENTS_BY_RECIEVER_IDX, messageRecipientsDto);
	}
	
	public List<MessageDto> selectTblMessageByMemberIdx(int memberIdx) {
		return sqlSession.selectList(SELECT_TBL_MESSAGE_BY_MEMBER_IDX, memberIdx);
	}
	
	public Date selectNow() {
		return sqlSession.selectOne(SELECT_NOW);
	}
	
	public Integer selectTblMessageRecipientsToUnreadCount(Integer messageGroupIdx) {
		return sqlSession.selectOne(SELECT_TBL_MESSAGE_RECIPIENTS_TO_UNREAD_COUNT, messageGroupIdx);
	}
	
	public List<AlarmDto> selectActivityByScoreIdx(Integer memberIdx){
		return sqlSession.selectList(SELECT_ACTIVITY_BY_SCORE_IDX , memberIdx);
	}
	
	public List<AlarmDto> selectActivityByPrimaryIdx(Integer memberIdx){
		return sqlSession.selectList(SELECT_ACTIVITY_BY_PRIMARY_IDX  , memberIdx);
	}
}
