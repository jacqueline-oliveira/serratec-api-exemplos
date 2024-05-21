package br.com.serratec.livraria.dto;

import br.com.serratec.livraria.config.Mapper;
import br.com.serratec.livraria.model.Editora;

public record EditoraDto(
		 Long id,
		 String nome,
		 RegistroFuncionamentoDto registro)  {
	
	public Editora toEntity() {
		return Mapper.getMapper().convertValue(this, Editora.class);
	}

}
