package br.com.serratec.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
