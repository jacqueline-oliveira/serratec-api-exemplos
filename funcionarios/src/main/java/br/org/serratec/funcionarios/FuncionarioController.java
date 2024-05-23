package br.org.serratec.funcionarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repositorio;
	
	@GetMapping
	public ResponseEntity<Page<Funcionario>> obterTodos(
			@PageableDefault(size = 5, page = 0, sort = "nome", 
			direction = Sort.Direction.ASC) Pageable pageable) {
		
		Page<Funcionario> funcionarios = repositorio.findAll(pageable); 
		return ResponseEntity.ok(funcionarios);
	}

}
