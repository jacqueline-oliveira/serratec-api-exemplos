package br.org.serratec.aula02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	@GetMapping
	public String obterSaudacao() {
		return "Olá alunos da Serratec!";
	}
	
	@GetMapping("/{nome}")
	public String obterSaudacaoPersonalizada(@PathVariable String nome) {
		return "Olá " + nome + "! Boas vindas ao Serratec!";
	}
	
	@GetMapping("/texto")
	public String obterTextoDigitado(@RequestBody String texto) {
		return "Texto enviado pelo usuário: " + texto;
	}
	
	
	@GetMapping("/objeto")
	public String obterObjetoEnviado(@RequestBody Aluno aluno) {
		return aluno.exibeDadosAluno();
	}

}
