package br.com.serratec.aula05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.aula05.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
