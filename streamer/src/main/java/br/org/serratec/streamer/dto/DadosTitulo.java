package br.org.serratec.streamer.dto;

import java.util.OptionalDouble;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.streamer.model.Genero;
import br.org.serratec.streamer.model.Titulo;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTitulo(
		@JsonAlias("Title") String titulo,
		@JsonAlias("Genre") String genero,
		@JsonAlias("imdbRating") String avaliacao,
		@JsonAlias("totalSeasons") int totalTemporadas) {

	public Titulo toEntity() {
		Titulo titulo = new Titulo();
		titulo.setTitulo(this.titulo);
		titulo.setGenero(Genero.toGenero(this.genero.split(",")[0].trim()));
		titulo.setAvaliacao(OptionalDouble.of(Double.valueOf(this.avaliacao)).orElse(0));
		titulo.setTotalTemporadas(this.totalTemporadas);
		return titulo;
	}
}
