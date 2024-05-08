package br.org.serratec.aula03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	List<Aluno> alunos = new ArrayList<>();
	int id = 0;
	
	@GetMapping
	public List<Aluno> obterTodos() {
		return alunos;
	}
	
	
	@GetMapping("/{id}")
	public Aluno obterAluno(@PathVariable int id) {
		int indice = obterPosicaoLista(id);
		
		if (indice != -1) {
			return alunos.get(indice);
		}
		
		return null;
	}
	
	
	@DeleteMapping("/{id}")
	public void excluirAluno(@PathVariable int id) {
		int indice = obterPosicaoLista(id);
		
		if (indice != -1) {
			alunos.remove(indice);
		}
	}
	
	
	@PostMapping
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		aluno.setId(++id);
		alunos.add(aluno);
		return aluno;
	}
	
	@PutMapping("/{id}")
	public Aluno alteraAluno(@PathVariable int id, @RequestBody Aluno alunoAlterado) {
		int indice = obterPosicaoLista(id);
		
		if (indice != -1) {
			alunoAlterado.setId(id);
			alunos.set(indice, alunoAlterado);
			return alunoAlterado;	
		}
		return null;
	}
	
	private int obterPosicaoLista(int id) {
		for(int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
