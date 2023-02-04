package com.bvdev.alcoholproject.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ConvertUtil {
	public String convertStringToStrIntegerArr(String param) throws Exception {
		String paramArr [] = param.split(",");
		
		String strIntegerArr = "{";
		for (int i=0; i<paramArr.length; i++) {
			strIntegerArr += (paramArr[i] + ",");
		}
		strIntegerArr = strIntegerArr.substring(0,(strIntegerArr.length() - 1));
		strIntegerArr += "}";

		return strIntegerArr;
	}
	
	public String convertStringToStrStringArr(String param) throws Exception {
		String paramArr [] = param.split(",");
		
		String strStringArr = "{";
		for (int i=0; i<paramArr.length; i++) {
			strStringArr += ("'" + paramArr[i] + "',");
		}
		strStringArr = strStringArr.substring(0,(strStringArr.length() - 1));
		strStringArr += "}";

		return strStringArr;
	}
	
	public List<Integer> convertStringToIntegerList(String param) throws Exception {
		String paramArr [] = param.split(",");
		
		List<Integer> paramList = new ArrayList<Integer>();
		
		for (int i=0; i<paramArr.length; i++) {
			paramList.add(Integer.parseInt(paramArr[i]));
		}
		
		return paramList;
	}
	
	public List<String> convertStringToStringList(String param) throws Exception {
		String paramArr [] = param.split(",");
		
		List<String> paramList = new ArrayList<String>();
		
		for (int i=0; i<paramArr.length; i++) {
			paramList.add(paramArr[i]);
		}
		
		return paramList;
	}
}