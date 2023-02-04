package com.bvdev.alcoholproject.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiDao;
import com.bvdev.alcoholproject.api.dto.ApiKeyDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")

public class ApiController {
	@Inject
	private ApiDao apiDao;

	@ApiOperation(value = "SELECT_TBL_APIKEY_LIST", notes = "SELECT_TBL_APIKEY_LIST")
	@GetMapping(value = "/apiKey/selectApiKeyList")
	public List<ApiKeyDto> selectTblApiKeyList() throws NumberFormatException, Exception {

		List<ApiKeyDto> apikeyDtoList = apiDao.selectlTblApiKeyList();

		return apikeyDtoList;
	}

	@ApiOperation(value = "INSERT_APIKEY", notes = "INSERT APIAPIKEY")
	@PostMapping(value = "/apiKey/registerApiKey")
	public Map<String, String> registerApiKey(@RequestParam String comment, HttpServletRequest request)
			throws NumberFormatException, Exception {
		ApiKeyDto newKey = new ApiKeyDto();
		UUID uuid = UUID.randomUUID();

		newKey.setKeyValue(uuid.toString());
		newKey.setKeyComment(comment);
		newKey.setAuthGrade(0);
		newKey.setCreater(request.getHeader("Authorization"));

		newKey.setCreateDate(new Date());
		newKey.setUpdater("bvdev");
		newKey.setUpdateDate(new Date());
		int resultCnt = apiDao.insertTblApiKey(newKey);

		Map<String, String> result = new HashMap<>();

		if (resultCnt == 1) {
			result.put("result", "200");
			result.put("massage", "ApiKey가 정상적으로 생성되었습니다.");
		} else
			result.put("result", "ApiKey가 생성되지 않았습니다.");
		return result;
	}
}