package br.com.serratec.livraria.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros")
public class RegistroFuncionamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnpj;
	private String alvara;
	private LocalDate dataAutorizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getAlvara() {
		return alvara;
	}
	public void setAlvara(String alvara) {
		this.alvara = alvara;
	}
	public LocalDate getDataAutorizacao() {
		return dataAutorizacao;
	}
	public void setDataAutorizacao(LocalDate dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}	

}
