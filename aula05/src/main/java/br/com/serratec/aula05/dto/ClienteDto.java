package br.com.serratec.aula05.dto;

import java.time.LocalDate;

import br.com.serratec.aula05.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record ClienteDto(
		 Long id,
		 @NotBlank
		 String nome,
		 @Pattern(regexp = "\\d{11}")
		 @NotBlank
		 String cpf,
		 @Email(message= "E-mail inválido. Informe um e-mail no padrão, incluindo @ e .")
		 @NotBlank
		 String email,
		 @Past(message= "Data de nascimento deve ser no passado")
		 @NotNull
		 LocalDate dataNascimento) {

	public Cliente toEntity() {
		return new Cliente(this.id, this.nome, this.cpf(), this.email,
				this.dataNascimento);
	}

}
