package br.org.serratec.streamer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.streamer.dto.DadosEpisodio;
import br.org.serratec.streamer.dto.DadosTitulo;

@Service
public class CatalogoService {
	
	@Autowired
	private ConverteDados conversor;
	
	public DadosTitulo obterDados(String titulo) {
		var json = ConsumoApi.obterDados(titulo);
		return conversor.converteParaTitulo(json);
	}

	public List<DadosEpisodio> obterDadosEpisodio(String titulo, int temporada) {
		var json = ConsumoApi.obterDados(titulo, temporada);
		return null;
	}

}
