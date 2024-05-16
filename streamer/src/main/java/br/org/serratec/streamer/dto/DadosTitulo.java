package br.org.serratec.streamer.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTitulo(
		@JsonAlias("Title") String titulo,
		@JsonAlias("Genre") String genero,
		@JsonAlias("imdbRating") String avaliacao,
		@JsonAlias("totalSeasons") int totalTemporadas) {
}
