package com.bvdev.alcoholproject.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bvdev.alcoholproject.api.dto.MediaDto;

@Component
public class FileUtil {
	final String uploadPath = "/resources/upload/";
	
	public List<MediaDto> uploadMultiFile(HttpServletRequest request) throws Exception {
		final String filePath = request.getServletContext().getRealPath(uploadPath);
		List<MultipartFile> mediaFileList = (List<MultipartFile>) request.getAttribute("mediaFileList");
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String saveFileName = null;
		
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		List<MediaDto> mediaDtoList = new ArrayList<MediaDto>();
		for (int i=0; i<mediaFileList.size(); i++) {
			multipartFile = mediaFileList.get(i);
			
			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				saveFileName = Functions.getRandomString() + originalFileExtension;
				file = new File(filePath + saveFileName);
				multipartFile.transferTo(file);
				
				MediaDto mediaDto = new MediaDto();
				mediaDto.setOriginMediaFilename(originalFileName);
				String mediaFilename = filePath + saveFileName;
				mediaFilename = mediaFilename.replace("/", "\\");
				mediaDto.setMediaFilename(mediaFilename);
				mediaDto.setFileSize(multipartFile.getSize());
				
				mediaDtoList.add(mediaDto);
			}
		}
		
		return mediaDtoList;
	}
	
	public MediaDto uploadFile(HttpServletRequest request) throws Exception {
		final String filePath = request.getServletContext().getRealPath(uploadPath);
		MultipartFile mediaFile = (MultipartFile) request.getAttribute("mediaFile");
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String saveFileName = null;
		
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		multipartFile = mediaFile;
		
		MediaDto mediaDto = new MediaDto();
		if (multipartFile.isEmpty() == false) {
			originalFileName = multipartFile.getOriginalFilename();
			originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			saveFileName = Functions.getRandomString() + originalFileExtension;
			file = new File(filePath + saveFileName);
			multipartFile.transferTo(file);
			
			mediaDto.setOriginMediaFilename(originalFileName);
			String mediaFilename = filePath + saveFileName;
			mediaFilename = mediaFilename.replace("/", "\\");
			mediaDto.setMediaFilename(mediaFilename);
			mediaDto.setFileSize(multipartFile.getSize());
		}
		
		return mediaDto;
	}
}