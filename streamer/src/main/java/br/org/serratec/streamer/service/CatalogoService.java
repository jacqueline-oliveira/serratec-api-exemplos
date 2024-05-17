package br.org.serratec.streamer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.streamer.dto.DadosTemporada;
import br.org.serratec.streamer.dto.DadosTitulo;
import br.org.serratec.streamer.model.Episodio;
import br.org.serratec.streamer.model.Titulo;
import br.org.serratec.streamer.repository.CatalogoRepository;

@Service
public class CatalogoService {
	@Autowired
	private CatalogoRepository repositorio;
	
	@Autowired
	private ConverteDados conversor;
	
	public DadosTitulo obterDados(String titulo) {
		var json = ConsumoApi.obterDados(titulo);
		DadosTitulo dadosTitulo = conversor.converter(json, DadosTitulo.class);
		Optional<Titulo> tituloEntity = repositorio.findByTituloIgnoreCase(dadosTitulo.titulo());
		
		if (tituloEntity.isEmpty()) {
			repositorio.save(dadosTitulo.toEntity());	
		}
		
		return dadosTitulo;
	}

	public DadosTemporada obterDadosEpisodio(String titulo, int temporada) {
		var json = ConsumoApi.obterDados(titulo, temporada);
		DadosTemporada dadosTemporada = conversor.converter(json, DadosTemporada.class);
		Optional<Titulo> tituloEntity = repositorio.findByTituloIgnoreCase(dadosTemporada.titulo());
		
		if (tituloEntity.isPresent()) {
			List<Episodio> episodios = dadosTemporada.episodios().stream()
					.map(e -> e.toEntity(temporada))
					.collect(Collectors.toList());
			
			tituloEntity.get().setEpisodios(episodios);
			repositorio.save(tituloEntity.get());	
		}
		
		return dadosTemporada;
	}

}
