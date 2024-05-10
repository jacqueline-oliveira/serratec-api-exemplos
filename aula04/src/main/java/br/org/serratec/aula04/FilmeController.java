package br.org.serratec.aula04;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repositorio;
	
	@GetMapping
	public ResponseEntity<List<Filme>> obterTodosOsFilmes() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@PostMapping
	public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
		repositorio.save(filme);
		return new ResponseEntity<Filme>(filme, HttpStatus.CREATED);
		
		//URI endpoint = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
	    //return ResponseEntity.created(endpoint).body(filme);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> obterPorId(@PathVariable Long id) {
		Optional<Filme> filme = repositorio.findById(id);
		
		if (filme.isPresent()) {
			return ResponseEntity.ok(filme.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> alterarDadosFilme(@PathVariable Long id, @RequestBody Filme filmeAlterado) {
		if (repositorio.existsById(id)) {
			filmeAlterado.setId(id);
			repositorio.save(filmeAlterado);
			return ResponseEntity.ok(filmeAlterado);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	
	
	
	
	
	
	
}
