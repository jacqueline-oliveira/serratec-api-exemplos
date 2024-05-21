package br.com.serratec.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.livraria.model.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
