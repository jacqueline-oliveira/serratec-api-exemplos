package br.org.serratec.streamer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.streamer.model.Titulo;

public interface CatalogoRepository extends JpaRepository<Titulo, Long> {
	
	Optional<Titulo> findByTituloIgnoreCase(String titulo);
	

}
