package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Util;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveUser(@RequestBody User u) {
		boolean operacion = userService.saveUser(u);
		LOGGER.info("Resultado Operacion{} ",Util.jsonMe(operacion));
		return ResponseEntity.ok(operacion);
	}
}
