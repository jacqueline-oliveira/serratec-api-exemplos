package br.org.serratec.streamer.service;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.serratec.streamer.dto.DadosTitulo;

@Component
public class ConverteDados {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public DadosTitulo converteParaTitulo(String json) {
		try {
			return mapper.readValue(json, DadosTitulo.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
