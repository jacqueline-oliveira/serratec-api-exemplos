package br.com.serratec.aula05.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.aula05.dto.ClienteDto;
import br.com.serratec.aula05.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService servico;

	@GetMapping
	public ResponseEntity<List<ClienteDto>> listar(){
		return ResponseEntity.ok(servico.obterTodos());
	}
	
	@GetMapping("/nascimento")
	public ResponseEntity<List<ClienteDto>> obterClientesPorNascimento(@RequestBody String nascimento){
		return ResponseEntity.ok(servico.obterPorNascimento(nascimento));
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<ClienteDto>> obterClientePorNome(@RequestBody String nome){
		return ResponseEntity.ok(servico.obterPorNome(nome));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> buscar(@PathVariable Long id) {
		Optional<ClienteDto> cliente = servico.obterPorId(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto inserir(@Valid @RequestBody ClienteDto cliente) {
		return servico.salvarCliente(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody ClienteDto clienteAlterado) {
		Optional<ClienteDto> cliente = servico.atualizarCliente(id, clienteAlterado);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(cliente.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if(!servico.excluirCliente(id)){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
