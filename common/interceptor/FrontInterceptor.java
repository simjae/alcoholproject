package com.bvdev.alcoholproject.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class FrontInterceptor extends HandlerInterceptorAdapter{

    protected Log log = LogFactory.getLog(FrontInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	
    	String urlToken[] = request.getRequestURI().split("/");
    	int tokenSize = urlToken.length;
    	
    	System.out.println("pre Request URI \t:  " + urlToken[tokenSize-1]);

    	HttpSession httpSession = request.getSession();

    	if( httpSession.getAttribute("id") == null) {
        	request.getRequestDispatcher("/front/login").forward(request, response);
        	System.out.println("no session");
        	return false;
    	}
    	request.setAttribute("sessionInfo", httpSession);
    	
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