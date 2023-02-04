package com.bvdev.alcoholproject.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiMemberDao;
import com.bvdev.alcoholproject.api.dao.ApiMessageDao;
import com.bvdev.alcoholproject.api.dto.MessageDto;
import com.bvdev.alcoholproject.api.dto.AlarmDto;
import com.bvdev.alcoholproject.api.dto.MessageRecipientsDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")

public class ApiMessageController {

	@Inject
	private ApiMessageDao apiMessageDao;

	@Inject
	private ApiMemberDao apiMemberDao;

	@ApiOperation(value = "CONNECT MESSAGE ROOM", notes = "CONNECT MESSAGE ROOM")
	@GetMapping(value = "/message/list")
	public List<MessageDto> messageListApi(
		@RequestParam Integer senderMemberIdxParam ,
		HttpServletRequest request, 
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		List<MessageDto> resultList = new ArrayList<MessageDto>();
		
		if(senderMemberIdxParam != null) {
			resultList = apiMessageDao.selectTblMessageByMemberIdx(senderMemberIdxParam);
		}
		return resultList;
	}
	
	@ApiOperation(value = "CONNECT MESSAGE ROOM", notes = "CONNECT MESSAGE ROOM")
	@GetMapping(value = "/message/connect")
	public Map<String, Object> connectMessageApi(
		@RequestParam Integer senderMemberIdxParam,
		@RequestParam Integer recieverMemberIdxParam, 
		HttpServletRequest request, 
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		List<MessageDto> messageDtoList = new ArrayList<MessageDto>();
		Map<String, Object> messageRecipients = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Integer messageGroupIdx = -1;
		
	 	messageRecipients = getMessageGroupIdx(senderMemberIdxParam, recieverMemberIdxParam);
		messageGroupIdx = (Integer) messageRecipients.get("messageGroupIdx");
		System.out.println("messageGroupIdx : " + messageGroupIdx);
		MessageDto messageDto = new MessageDto();

		if ((messageGroupIdx == null || messageGroupIdx <= 0) && messageRecipients.get("senderIdx") != null) {
			int idx = apiMessageDao.insertTblMessageRecipients(messageRecipients);
			if (idx > 0) {
				messageGroupIdx = apiMessageDao.selectTblMessageRecipientsBySenderIdx(messageRecipients);
				messageDto.setMemberIdx(0);
				messageDto.setMessageGroupIdx(messageGroupIdx);
				messageDto.setMessageContent("========MESSAGE ROOM CREATE======");
				apiMessageDao.insertTblMessage(messageDto);

				messageDto.setMemberIdx(senderMemberIdxParam);
				messageDtoList = apiMessageDao.selectTblMessageBymessageGroupIdx(messageDto);
				messageDtoList.remove(messageDtoList.size()-1);
				
				result.put("result", 200);
				result.put("message_group_idx", messageGroupIdx);
				result.put("data", messageDtoList);
			}
			return result;
		} else {
			messageDto.setMemberIdx(senderMemberIdxParam);
			messageDto.setMessageGroupIdx(messageGroupIdx);
			messageDtoList = apiMessageDao.selectTblMessageBymessageGroupIdx(messageDto);
			messageDtoList.remove(messageDtoList.size()-1);
			
			if(messageDtoList != null && !messageDtoList.isEmpty()) {
				int unreadCount = messageDtoList.get(0).getUnreadCount();
				for(int i = 0 ; i < messageDtoList.size() ; i++) {
					if(i < unreadCount) {
						messageDtoList.get(messageDtoList.size()-1-i).setUnreadFlg(true);
					}
				}
			}
			
			result.put("result", 200);
			result.put("messageGroupIdx", messageGroupIdx);
			result.put("data", messageDtoList);
			return result;
		}
	}

	@ApiOperation(value = "REGIST MESSAGE", notes = "REGIST MESSAGE ROOM")
	@PostMapping(value = "/message/regist")
	public Map<String, Object> registMessageApi(
			@RequestParam Integer senderMemberIdxParam,
			@RequestParam Integer recieverMemberIdxParam, 
			@RequestParam String contentParam, 
			HttpServletRequest request, HttpServletResponse response)
		throws NumberFormatException, Exception {

		Map<String, Object> messageRecipients = new HashMap<String, Object>();
		Integer messageGroupIdx = -1;
		
		messageRecipients = getMessageGroupIdx(senderMemberIdxParam, recieverMemberIdxParam);
		if(messageRecipients != null) {
			messageGroupIdx = (Integer) messageRecipients.get("messageGroupIdx");
		}
		
		Map<String, Object> resultMap = new HashMap<>();
		if (messageGroupIdx != null && messageGroupIdx > 0) {
			String content = contentParam;
			if (senderMemberIdxParam != null && senderMemberIdxParam > 0) {
				MessageDto messageDto = new MessageDto();

				MessageRecipientsDto messageRecipientsDto = new MessageRecipientsDto();
				messageRecipientsDto.setMemberIdx(senderMemberIdxParam);
				messageRecipientsDto.setMessageGroupIdx(messageGroupIdx);

				if (recieverMemberIdxParam != null && recieverMemberIdxParam > 0) {
					messageDto.setMemberIdx(senderMemberIdxParam);
					messageDto.setMessageGroupIdx(messageGroupIdx);
					messageDto.setMessageContent(content);
					Integer result = apiMessageDao.insertTblMessage(messageDto);
					
					messageRecipientsDto.setMemberIdx(recieverMemberIdxParam);
					messageRecipientsDto.setUnreadCount(1);
					apiMessageDao.updateTblMessageRecipients(messageRecipientsDto);
					
					messageDto.setIdx(result);
					List<MessageDto> resultList = new ArrayList<MessageDto>();
					resultList = apiMessageDao.selectTblMessageBymessageGroupIdx(messageDto);
					resultList.remove(resultList.size()-1);
					
					if (result != null && result > 0) {
						resultMap.put("result", "200");
						resultMap.put("data", resultList);
						resultMap.put("message", "Regist Message Success");

						return resultMap;
					}
				}
			}
		}
		resultMap.put("result", "-1");
		resultMap.put("message", "Regist Message Fail");
		return resultMap;
	}

	@ApiOperation(value = "REGIST MESSAGE", notes = "REGIST MESSAGE ROOM")
	@GetMapping(value = "/message/refresh")
	public Map<String, Object> refreshMessageApi(
			@RequestParam int senderIdxParam,
			@RequestParam int messageGroupIdxParam, 
			@RequestParam String timeStampParam,
			HttpServletRequest request,
			HttpServletResponse response) 
		throws NumberFormatException, Exception {

		Map<String, Object> resultMap = new HashMap<>();
		Integer messageGroupIdx = -1;
		Integer memberIdx = senderIdxParam;
		
		messageGroupIdx = messageGroupIdxParam;
		if (memberIdx != null && memberIdx > 0) {
			MessageDto messageDto = new MessageDto();
			messageDto.setMemberIdx(memberIdx);
			messageDto.setMessageGroupIdx(messageGroupIdx);
			messageDto.setTimeStamp(timeStampParam);
			
			List<MessageDto> emptyDtoList = new ArrayList<MessageDto>();
			MessageRecipientsDto messageRecipientsDto = new MessageRecipientsDto();

			messageRecipientsDto.setMemberIdx(memberIdx);
			messageRecipientsDto.setMessageGroupIdx(messageGroupIdx);
			messageRecipientsDto.setUnreadCount(0);
			apiMessageDao.updateTblMessageRecipients(messageRecipientsDto);
			
			List<MessageDto> resultList = apiMessageDao.selectTblMessageBymessageGroupIdx(messageDto);
			Date refreshTimeStamp = resultList.get(resultList.size()-1).getMessageSendTime();
			resultList.remove(resultList.size()-1);
			
			for(int i = 0; i < resultList.size(); i++) {
				if(senderIdxParam == resultList.get(i).getMemberIdx()) {
					resultList.get(i).setUnreadFlg(true);
				}
			}
			
			Integer unreadCount = apiMessageDao.selectTblMessageRecipientsToUnreadCount(messageGroupIdxParam);
			resultMap.put("timestamp", refreshTimeStamp);
			resultMap.put("message", resultList);
			resultMap.put("threads", emptyDtoList);
			if(unreadCount == 0) {
				resultMap.put("recieverReadFlg", true);
			}
			else {
				resultMap.put("recieverReadFlg", false);
			}
			return resultMap;
		}
		return null;
	}
	
	@ApiOperation(value = "ADD PAST MESSAGE", notes = "ADD PAST MESSAGE")
	@GetMapping(value = "/message/pastAdd")
	public Map<String, Object> pastAddhMessageApi(
			@RequestParam int senderIdxParam, // 13
			@RequestParam int messageGroupIdxParam,  //8
			@RequestParam Integer lastMessageIdxParam, 		//215
			HttpServletRequest request,
			HttpServletResponse response) 
	throws NumberFormatException, Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(senderIdxParam > 0 && messageGroupIdxParam > 0){
			if(lastMessageIdxParam != null && lastMessageIdxParam > 0) {
				MessageDto messageDto = new MessageDto();
				messageDto.setMemberIdx(senderIdxParam);
				messageDto.setMessageGroupIdx(messageGroupIdxParam);
				messageDto.setIdx(lastMessageIdxParam);
				
				resultMap.put("message", apiMessageDao.selectTblMessageBymessageGroupIdx(messageDto));
				
				return resultMap;
			}
		}
		
		return null;
	}
	
	@ApiOperation(value = "SELECT MESSASGE NOTIFICATION", notes = "SELECT MESSASGE NOTIFICATION")
	@GetMapping(value = "/message/alarm")
	public List<AlarmDto> selectMassageNotification(
			@RequestParam Integer memberIdxParam, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws NumberFormatException, Exception {
		if(memberIdxParam != null && memberIdxParam > 0) {
			List<AlarmDto> scoreAlarmList = new ArrayList<AlarmDto>();
			List<AlarmDto> reflyAlarmList = new ArrayList<AlarmDto>();
			List<AlarmDto> alarmList = new ArrayList<AlarmDto>();
			
			scoreAlarmList = apiMessageDao.selectActivityByScoreIdx(memberIdxParam);
			reflyAlarmList = apiMessageDao.selectActivityByPrimaryIdx(memberIdxParam);
			
			int scoreAlarmSize = scoreAlarmList.size();
			int reflyAlarmSize = reflyAlarmList.size();
			
			int scoreAlarmIdx = 0;
			int reflyAlarmIdx = 0;
			
			while(!(scoreAlarmIdx >= scoreAlarmSize && 
					reflyAlarmIdx >= reflyAlarmSize)) {
				//scoreNotificationList의 데이터를 모두 가져온 상태라면
				//reflyNotificationList데이터를 마저 채워 넣는다.
				if(scoreAlarmIdx >= scoreAlarmSize) {
					alarmList.add(reflyAlarmList.get(reflyAlarmIdx));
					reflyAlarmIdx++;
				}
				//reflyNotificationList의 데이터를 모두 가져온 상태라면
				//scoreNotificationList데이터를 마저 채워 넣는다.
				else if(reflyAlarmIdx >= reflyAlarmSize) {
					alarmList.add(scoreAlarmList.get(scoreAlarmIdx));
					scoreAlarmIdx++;
				}
				//두 List 데이터가 남아있다면
				//날짜를 비교하여 이전의 데이터 부터 밀어넣는다.
				else {
					if(scoreAlarmList.get(scoreAlarmIdx).getCreateDate()
							.after(reflyAlarmList.get(reflyAlarmIdx).getCreateDate())) {
						alarmList.add(scoreAlarmList.get(scoreAlarmIdx));
						scoreAlarmIdx++;
					}
					else if(scoreAlarmList.get(scoreAlarmIdx).getCreateDate()
							.equals(reflyAlarmList.get(reflyAlarmIdx).getCreateDate())) {
						alarmList.add(scoreAlarmList.get(scoreAlarmIdx));
						alarmList.add(reflyAlarmList.get(reflyAlarmIdx));
						scoreAlarmIdx++;
						reflyAlarmIdx++;
					}
					else if(scoreAlarmList.get(scoreAlarmIdx).getCreateDate()
							.before(reflyAlarmList.get(reflyAlarmIdx).getCreateDate())) {
						alarmList.add(reflyAlarmList.get(reflyAlarmIdx));
						reflyAlarmIdx++;
					}
				}
			}
			
			return alarmList;
		}
		return null;
	}
	
	
	public Map<String, Object> getMessageGroupIdx(Integer senderMemberIdxParam, Integer recieverMemberIdxParam) throws Exception {
		Integer messageGroupIdx = -1;
		Map<String, Object> messageRecipients = new HashMap<String, Object>();

		if (senderMemberIdxParam != null && recieverMemberIdxParam != null) {

			Integer senderDelChk = apiMemberDao.selectTblMemberByIdxAndDelFlg(senderMemberIdxParam);
			Integer recieverDelChk = apiMemberDao.selectTblMemberByIdxAndDelFlg(recieverMemberIdxParam);
			if ((senderDelChk != null && recieverDelChk != null) && (senderDelChk > 0 && recieverDelChk > 0)) {
				messageRecipients.put("senderIdx", senderMemberIdxParam);
				messageRecipients.put("recieverIdx", recieverMemberIdxParam);
				messageRecipients.put("creater", "bvdev");
				messageRecipients.put("updater", "bvdev");

				messageGroupIdx = apiMessageDao.selectTblMessageRecipientsBySenderIdx(messageRecipients);
				messageRecipients.put("messageGroupIdx", messageGroupIdx);
			}
			messageRecipients.put("messageGroupIdx", messageGroupIdx);
		}
		messageRecipients.put("messageGroupIdx", messageGroupIdx);
		return messageRecipients;
	}
}
