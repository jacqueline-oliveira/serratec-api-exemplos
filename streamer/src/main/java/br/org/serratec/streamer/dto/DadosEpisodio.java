package br.org.serratec.streamer.dto;

import java.time.LocalDate;
import java.util.OptionalDouble;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.streamer.model.Episodio;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
		@JsonAlias("Episode") int numero,
		@JsonAlias("Title") String titulo,
		@JsonAlias("Released") String dataLancamento,
		@JsonAlias("imdbRating") String avaliacao
		) {

	public Episodio toEntity(int temporada) {
		Episodio episodio = new Episodio();
		episodio.setTemporada(temporada);
		episodio.setNumero(this.numero);
		episodio.setDescricao(this.titulo);
		episodio.setDataLancamento(LocalDate.parse(this.dataLancamento));
		if (!this.avaliacao.equalsIgnoreCase("N/A")) {
		episodio.setAvaliacao(OptionalDouble.of(Double.valueOf(this.avaliacao)).orElse(0));
		}
		
		return episodio;
	}

}
