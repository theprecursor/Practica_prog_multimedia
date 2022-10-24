package com.example.demo.service;

public interface SendEmail {
	
	boolean sendEmail(String to, String subject, String content);
}
