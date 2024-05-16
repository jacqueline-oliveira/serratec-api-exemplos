package br.org.serratec.streamer.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosEpisodio(
		@JsonAlias("Episode") int numero,
		@JsonAlias("Title") String titulo,
		@JsonAlias("Released") String dataLancamento,
		@JsonAlias("imdbRating") String avaliacao
		) {

}
