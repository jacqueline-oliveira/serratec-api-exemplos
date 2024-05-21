package br.com.serratec.livraria.dto;

import java.util.List;

import br.com.serratec.livraria.config.Mapper;
import br.com.serratec.livraria.model.Livro;

public record LivroDto(
		Long id,
		String titulo,
		String isbn,
		int anoLancamento,
		EditoraDto editora,
		List<AutorDto> autores)  {
	
	public Livro toEntity() {
		return Mapper.getMapper().convertValue(this, Livro.class);
		
	}

	public static LivroDto toDto(Livro livroEntity) {
		return Mapper.getMapper().convertValue(livroEntity, LivroDto.class);
	}

}
