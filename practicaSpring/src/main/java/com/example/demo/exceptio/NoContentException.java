package com.example.demo.exceptio;

public class NoContentException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8513846877651814725L;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public NoContentException(String error) {
		this.error = error;
	}
	
	
}
