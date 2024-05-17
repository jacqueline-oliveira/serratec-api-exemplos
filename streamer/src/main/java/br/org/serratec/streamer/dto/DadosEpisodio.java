package br.org.serratec.streamer.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
		@JsonAlias("Episode") int numero,
		@JsonAlias("Title") String titulo,
		@JsonAlias("Released") String dataLancamento,
		@JsonAlias("imdbRating") String avaliacao
		) {

}
