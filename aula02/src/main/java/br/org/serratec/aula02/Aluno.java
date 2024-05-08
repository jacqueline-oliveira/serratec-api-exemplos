package br.org.serratec.aula02;

public class Aluno {
	private String nome;
	private String curso;
	private String periodo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String exibeDadosAluno() {
		return String.format("Aluno: %s - Curso: %s - Período: %s",
				nome, curso, periodo);
	}

}
