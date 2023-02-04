package com.bvdev.alcoholproject.common.util;

import java.util.UUID;

public class Functions {
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
