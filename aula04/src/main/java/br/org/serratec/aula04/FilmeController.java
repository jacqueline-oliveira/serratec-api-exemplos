package br.org.serratec.aula04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repositorio;
	
	@GetMapping
	public List<Filme> obterTodosOsFilmes() {
		return repositorio.findAll();
	}

	@PostMapping
	public Filme cadastrarFilme(@RequestBody Filme filme) {
		repositorio.save(filme);
		return filme;
	}
	
	@GetMapping("/{id}")
	public Filme obterPorId(@PathVariable Long id) {
		return repositorio.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluirPorId(@PathVariable Long id) {
		repositorio.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
