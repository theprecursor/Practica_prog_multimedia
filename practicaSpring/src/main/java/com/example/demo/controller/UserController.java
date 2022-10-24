package com.example.demo.controller;

import java.lang.module.ResolutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptio.ResourceException;
import com.example.demo.model.ParametroEntradaContraseñaOlvidar;
import com.example.demo.model.ParametroEntradaPass;
import com.example.demo.model.ParametrosdeEntradaLogin;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@RestController
@RequestMapping(path = "/")
@Validated
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	private ResponseEntity<Boolean> saveUser(@RequestBody User user){
		boolean	saveUser = userservice.createUser(user);
		return ResponseEntity.ok(saveUser);
	}

	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	private ResponseEntity<User> loginUser(@RequestBody ParametrosdeEntradaLogin login){
	
		User u = userservice.logIn(login);
		
		if(u != null) {
			return ResponseEntity.ok(u);
		}else {
			throw new ResourceException(HttpStatus.NO_CONTENT,"Error Amigo Cristian. Coge mejor el usuario. De chill bro");
		}
		
	}
	
	@RequestMapping(value = "/usuario/forgetpaswd", method = RequestMethod.POST)
	private ResponseEntity<Boolean> forgetPasswd (@RequestBody ParametroEntradaContraseñaOlvidar fpaswd){
		boolean	forget = userservice.fpasswd(fpaswd);
		return ResponseEntity.ok(forget);
	}
	
	
	@RequestMapping(value = "usuario/changepaswd", method = RequestMethod.POST)
	private ResponseEntity<Boolean> changepaswd (@RequestHeader(value = "email") String email,
			@RequestBody ParametroEntradaPass cpasdw){
		
		boolean change = false;
		
		change = userservice.cpasswd(cpasdw, email);
		
		return ResponseEntity.ok(change);
	}
	
}
