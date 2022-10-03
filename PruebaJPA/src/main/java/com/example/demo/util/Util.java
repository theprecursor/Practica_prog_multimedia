package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Util {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	public static String jsonMe(Object o) {
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		
		try {
			json = ob.writeValueAsString(o);
		}catch(JsonProcessingException e) {
			json = "Object ["+o.getClass().getName()+"] not parseable";
			LOGGER.error("ERROR");
		}
		return json;
	}
	
}
