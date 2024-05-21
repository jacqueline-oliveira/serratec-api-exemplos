package br.com.serratec.livraria.dto;

import br.com.serratec.livraria.config.Mapper;
import br.com.serratec.livraria.model.Autor;
import br.com.serratec.livraria.model.Endereco;

public record AutorDto(
		Long id,
		String nome,
		Endereco endereco) {
	
	public Autor toEntity() {
		return Mapper.getMapper().convertValue(this, Autor.class);
	}

}
