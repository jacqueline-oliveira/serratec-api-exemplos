package br.com.serratec.aula05.dto;

import java.time.LocalDate;

import br.com.serratec.aula05.model.Cliente;

public record ClienteDto(
		 Long id,
		 String nome,
		 String cpf,
		 String email,
		 LocalDate dataNascimento) {

	public Cliente toEntity() {
		return new Cliente(this.id, this.nome, this.cpf(), this.email,
				this.dataNascimento);
	}

}
