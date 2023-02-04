package com.bvdev.alcoholproject.common.util;

public class MaskUtil {

	public static String maskPass(String password) {
		
		String maskPw = "";
	//	String maskPw = password;
		char[] charList = password.toCharArray();
		
		for(int i = 0; i < password.length(); i++) {
			charList[i] = '*';
		}
		maskPw = new String(charList);
		return maskPw;
	}
}
