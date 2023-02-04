package com.bvdev.alcoholproject.common.exception;

public class SessionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    private String message;
     
    public SessionException(String message) {
        super();
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
