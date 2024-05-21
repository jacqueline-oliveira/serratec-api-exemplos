package br.com.serratec.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.livraria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
