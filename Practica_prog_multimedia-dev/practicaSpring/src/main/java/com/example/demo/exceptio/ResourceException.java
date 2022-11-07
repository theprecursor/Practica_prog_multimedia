package com.example.demo.exceptio;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {
	
	
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
	
	
	
	
	public ResourceException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
}
