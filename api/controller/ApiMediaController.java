package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bvdev.alcoholproject.api.dao.ApiMediaDao;
import com.bvdev.alcoholproject.api.dto.MediaDto;
import com.bvdev.alcoholproject.common.util.FileUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiMediaController {
	@Inject
	private ApiMediaDao apiMediaDao;
	
	@ApiOperation(value = "INSERT TBL_MEDIA", notes = "INSERT TBL_MEDIA")
	@PostMapping(value = "/media/regist", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, String> insertTblMedia(
		//DROPZONE MEDIA FILE
		@RequestPart("mediaFile") MultipartFile mediaFile,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		//TBL_MEDIA 등록 확인용 플래그
		Boolean tblMediaResultFlg = false;
		
		//TBL_MEDIA 등록 처리
		int mediaIdx = 0;
		String originMediaFilename = "";
		String mediaFilename = "";
		if (mediaFile != null) {
			HttpSession session = request.getSession();
			
			int memberIdx = (int)session.getAttribute("idx");
			String memberId = (String)session.getAttribute("id");
			
			FileUtil fileUtil = new FileUtil();
			request.setAttribute("mediaFile", mediaFile);
			MediaDto mediaDto = fileUtil.uploadFile(request);
			
			mediaDto.setActivityIdx(0);
			mediaDto.setMemberIdx(memberIdx);
			mediaDto.setMediaType("photo");
			mediaDto.setMediaUploadType("activity");
			mediaDto.setCreater(memberId);
			mediaDto.setUpdater(memberId);
				
			mediaIdx = apiMediaDao.insertTblMedia(mediaDto);
			
			if (mediaIdx > 0) {
				//TBL_MEDIA 등록 : TRUE
				tblMediaResultFlg = true;
				originMediaFilename = mediaDto.getOriginMediaFilename();
				
				mediaFilename = apiMediaDao.selectTblMediaMediaFilenameByIdx(mediaIdx);
			}
		}
		
		Map<String, String> apiResult = new HashMap<String, String>();
		
		if (tblMediaResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("message", "이미지가 정상적으로 등록되었습니다.");
			apiResult.put("mediaIdx", String.valueOf(mediaIdx));
			apiResult.put("originMediaFilename", originMediaFilename);
			apiResult.put("mediaFilename",mediaFilename);
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "이미지 등록에 실패했습니다.");
		}
		
		return apiResult;
	}

	@ApiOperation(value = "DELETE TBL_MEDIA", notes = "DELETE TBL_MEDIA")
	@PostMapping(value = "/media/drop")
	public Map<String, String> deleteTblActivity(
		//TBL_MEDIA.origin_media_filename
		@RequestParam String filename,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		//TBL_MEDIA 갱신 확인용 플래그
		Boolean tblMediaResultFlg = false;
		
		//TBL_MEDIA 갱신 처리
		if (filename != null) {
			HttpSession session = request.getSession();
			
			String memberId = (String)session.getAttribute("id");
			
			MediaDto mediaDto = new MediaDto();
			mediaDto.setOriginMediaFilename(filename);
			mediaDto.setMediaDeleteFlg(true);
			mediaDto.setUpdater(memberId);
			
			int mediaResultCount = apiMediaDao.updateTblMedia(mediaDto);
			
			if (mediaResultCount > 0) {
				//TBL_MEDIA 갱신 : TRUE
				tblMediaResultFlg = true;
			}
		}
		
		Map<String, String> apiResult = new HashMap<String, String>();
		
		if (tblMediaResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("originMediaFilename",filename);
			apiResult.put("message", "이미지가 정상적으로 삭제되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "이미지 삭제에 실패했습니다.");
		}
		
		return apiResult;
	}
}