package br.com.serratec.aula05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.aula05.dto.ClienteDto;
import br.com.serratec.aula05.model.Cliente;
import br.com.serratec.aula05.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDto> obterTodos() {
		return clienteRepository.findAll().stream()
				.map(c -> new ClienteDto(c.getId(), c.getNome(), 
						c.getCpf(), c.getEmail(), c.getDataNascimento()))
				.toList();
	}
	
	public Optional<ClienteDto> obterPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return Optional.of(cliente.get().toDto());	
		}
		return Optional.empty();
	}

	public ClienteDto salvarCliente(ClienteDto cliente) {
		Cliente clienteEntity = clienteRepository.save(cliente.toEntity());
		return clienteEntity.toDto();
	}
	
	
	public Optional<ClienteDto> atualizarCliente(Long id, ClienteDto cliente){
		Cliente clienteEntity = cliente.toEntity();
		
		if (clienteRepository.existsById(id)) {
			clienteEntity.setId(id);
			clienteRepository.save(clienteEntity);
			return Optional.of(clienteEntity.toDto());
		}
		return Optional.empty();
	}
	
	public boolean excluirCliente(Long id) {
		if(!clienteRepository.existsById(id)){
			return false;
		}
		
		clienteRepository.deleteById(id);
		return true;
	}
	
	
	
	
	
	
	
	

}
