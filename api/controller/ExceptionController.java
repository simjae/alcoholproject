package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @RequestMapping(value = "/authError", method = { RequestMethod.GET ,RequestMethod.POST })
    public Map<String, String> getAuthError(HttpServletRequest request) throws Exception {
    	String code = (String) request.getAttribute("code");
    	String message = (String) request.getAttribute("message");
    	String exception = (String) request.getAttribute("exception");
    	
    	Map<String, String> result = new HashMap<>();
    	result.put("code", code);
    	result.put("message", message);
        result.put("exception", exception);

    	return result;
    }
}