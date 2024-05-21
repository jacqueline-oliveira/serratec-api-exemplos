package br.com.serratec.livraria.dto;

import java.time.LocalDate;

import br.com.serratec.livraria.config.Mapper;
import br.com.serratec.livraria.model.RegistroFuncionamento;

public record RegistroFuncionamentoDto(
		Long id,
		String cnpj,
		String alvara,
		LocalDate dataAutorizacao) {
	
	public RegistroFuncionamento toEntity() {
		return Mapper.getMapper().convertValue(this, RegistroFuncionamento.class);
	}

}
