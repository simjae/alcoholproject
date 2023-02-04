package com.bvdev.alcoholproject.common.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bvdev.alcoholproject.api.dao.ApiDao;

public class ApiInterceptor extends HandlerInterceptorAdapter{

    protected Log log = LogFactory.getLog(ApiInterceptor.class);
	@Inject
	private ApiDao swaggerDao;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	String urlToken[] = request.getRequestURI().split("/");
    	int tokenSize = urlToken.length;
    	
    	System.out.println("pre Request URI \t:  " + urlToken[tokenSize-1]);
    	System.out.println("pre Header Value \t:==" + request.getHeader("Authorization") + "==");
    	System.out.println(urlToken[tokenSize-2]);

    	if(request.getHeader("Authorization") == null) {
    		request.setAttribute("code", "ERR_001");
    		request.setAttribute("message", "Not input apiKey");
    		request.setAttribute("exception", "AuthenticationException");
        	request.getRequestDispatcher("/authError").forward(request, response);
        	return false;
    	}
    	else if(swaggerDao.selectTblApiKeyByKeyValue(request.getHeader("Authorization")).isEmpty()) {
    		request.setAttribute("code", "ERR_002");
    		request.setAttribute("message", "Not apiKey");
    		request.setAttribute("exception", "AuthenticationException");
        	request.getRequestDispatcher("/authError").forward(request, response);
        	return false;
        }
    	else if((urlToken[tokenSize-2].contentEquals("apiKey"))
    			&& swaggerDao.selectTblApiKeyByAdminKeyValue(request.getHeader("Authorization")).isEmpty()) {
    		request.setAttribute("code", "ERR_003");
    		request.setAttribute("message", "Not Admin apiKey");
    		request.setAttribute("exception", "AuthenticationException");
        	request.getRequestDispatcher("/authError").forward(request, response);
        	return false;
    	}
        else 
        	System.out.println("Header is apiKey");
    	/*
    	if (log.isDebugEnabled()) {
            log.debug("===================       START       ===================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
        }
        */
        return super.preHandle(request, response, handler);
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	System.out.println("post Request URI \t:  " + request.getRequestURI());
        if (log.isDebugEnabled()) {
            log.debug("===================        END        ===================\n");
        }
    }
 
}