package br.org.serratec.streamer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(
		@JsonAlias("Episodes") List<DadosEpisodio> episodios) {

}
