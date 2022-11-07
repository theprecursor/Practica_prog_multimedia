package com.example.demo.exceptio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(ResourceException.class)
	public ResponseEntity handleException(ResourceException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
	}
}
