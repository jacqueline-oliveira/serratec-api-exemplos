package br.com.serratec.livraria.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Mapper {
	
	private static final ObjectMapper mapper = new ObjectMapper(); 
	
	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new JavaTimeModule());
	}
	
	private Mapper() {}
	
	public static ObjectMapper getMapper() {
	  return mapper;
	}
}
