package com.bvdev.alcoholproject.common.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDtoToJson<T> {

	private Object globalParam;

	public ConvertDtoToJson(Object param) {
		globalParam = param;
	}

	public JSONObject convertDtoToJson() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		JSONObject jsonObj = new JSONObject();
		String jsonString = "";
		jsonString = mapper.writeValueAsString(globalParam);
		JSONParser jsonParser = new JSONParser();
		jsonObj = (JSONObject) jsonParser.parse(jsonString);
		
		return jsonObj;
	}
}