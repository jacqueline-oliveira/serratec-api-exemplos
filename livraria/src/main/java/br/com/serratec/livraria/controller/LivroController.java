package br.com.serratec.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.livraria.model.Livro;
import br.com.serratec.livraria.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroRepository repositorio;
	
	@GetMapping
	public List<Livro> obterTodos() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public Livro cadastrarLivro(@RequestBody Livro livro) {
		repositorio.save(livro);
		return livro;
	}

}
