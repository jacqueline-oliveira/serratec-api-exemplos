package br.org.serratec.streamer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.streamer.dto.DadosTemporada;
import br.org.serratec.streamer.dto.DadosTitulo;

@Service
public class CatalogoService {
	
	@Autowired
	private ConverteDados conversor;
	
	public DadosTitulo obterDados(String titulo) {
		var json = ConsumoApi.obterDados(titulo);
		return conversor.converter(json, DadosTitulo.class);
	}

	public DadosTemporada obterDadosEpisodio(String titulo, int temporada) {
		var json = ConsumoApi.obterDados(titulo, temporada);
		return conversor.converter(json, DadosTemporada.class);
	}

}
