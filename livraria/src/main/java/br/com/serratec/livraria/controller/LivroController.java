package br.com.serratec.livraria.controller;

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

import br.com.serratec.livraria.dto.LivroCadastroDto;
import br.com.serratec.livraria.dto.LivroDto;
import br.com.serratec.livraria.dto.RelatorioDto;
import br.com.serratec.livraria.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired 
	private LivroService servico;
	
	@GetMapping
	public ResponseEntity<List<LivroDto>> obterTodos() {
		return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> obterPorId(@PathVariable Long id) {
		Optional<LivroDto> dto = servico.obterLivroPorId(id);
		if (dto.isPresent()) {
			return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<List<RelatorioDto>> obterRelatorio() {
		return new ResponseEntity<>(servico.obterRelatorio(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody @Valid LivroDto livro) {
		return new ResponseEntity<>(servico.cadastraLivro(livro), HttpStatus.CREATED);
	}

	@PostMapping("/cadastro-com-id")
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroCadastroDto livro) {
		return new ResponseEntity<>(servico.gravarLivro(livro), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid LivroDto livro) {
		Optional<LivroDto> dto = servico.atualizarLivro(id, livro);
		
		if (dto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(dto.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if(!servico.excluirLivro(id)){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
