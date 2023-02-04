package com.bvdev.alcoholproject.common.util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDtoListToJson<T> {

	private List<T> globalParamList;
	
	public ConvertDtoListToJson(List<T> paramList){
		globalParamList = paramList;
	}
	
	public JSONArray convertDtoListToJson() throws Exception {
		
		int listSize = globalParamList.size();
		
		ObjectMapper mapper = new ObjectMapper();
    	
		JSONArray jsonArr = new JSONArray();
		for (int i=0; i<listSize; i++) {
    		String jsonString = "";
    		jsonString = mapper.writeValueAsString(globalParamList.get(i));
    		JSONParser jsonParser = new JSONParser();
    		Object obj = jsonParser.parse(jsonString);
    		
    		JSONObject tempObj = (JSONObject) obj;
    		
    		jsonArr.add(tempObj);
    	}
    	
		return jsonArr;
	}
}