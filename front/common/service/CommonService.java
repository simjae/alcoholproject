package com.bvdev.alcoholproject.front.common.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bvdev.alcoholproject.api.dao.ApiReplyDao;
import com.bvdev.alcoholproject.api.dto.ReplyDto;
import com.bvdev.alcoholproject.common.util.MessageUtils;
import com.bvdev.alcoholproject.front.common.vo.ReplyFormVo;

@Service
public class CommonService {

	@Inject
	private ApiReplyDao apiReplyDao;
	
	public ReplyFormVo replyActivityForm(int activityIdx, int memberIdx, String memberId) throws Exception {
		ReplyFormVo  replyFormVo = new ReplyFormVo();
		
		// 예외처리 : PARAM - ACTIVITY_IDX
		if (activityIdx < 0) {
			MessageUtils.getMessage("S_ERR_0002",new String[] {"PARAM.ACTIVITY_IDX"});
		}

		ReplyDto paramDto = new ReplyDto();
		paramDto.setMemberIdx(memberIdx);
		paramDto.setActivityIdx(activityIdx);
		
		ReplyDto replyDto = apiReplyDao.selectReplyInfo(paramDto);
		
		if (replyDto != null) {
			Boolean likeFlg = replyDto.getLikeFlg();
			String likeImg = "";
			if (likeFlg == true) {
				likeImg = "/alcoholProject/images/common/full_heart.svg";
			} else {
				likeImg = "/alcoholProject/images/common/empty_heart.svg";
			}
			replyDto.setLikeImg(likeImg);
			
			replyFormVo.setReplyDto(replyDto);
		}
		
		return replyFormVo;
	}
}