package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.service.SendEmail;

@Service
public class EnvioEmail implements SendEmail {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean sendEmail(String to, String subject, String content) {
		
		boolean envio = false;
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		try {
			email.setTo(to);
			email.setSubject(subject);
			email.setText(content);
			
			mailSender.send(email);
			envio = true;
		}catch (Exception e) {
			System.out.println("ERROR AL ENVIAR EL MENSAJE "+e.getMessage());
			envio = false;
		}
		
		return envio;
	}

}
