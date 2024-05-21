package br.com.serratec.livraria.dto;

import java.util.List;

import br.com.serratec.livraria.config.Mapper;
import br.com.serratec.livraria.model.Livro;

public record LivroCadastroDto(
		String titulo,
		String isbn,
		int anoLancamento,
		Long editoraId,
		List<Long> autoresId) {
	
	public Livro toEntity() {
		return Mapper.getMapper().convertValue(this, Livro.class);
	}
	
}
