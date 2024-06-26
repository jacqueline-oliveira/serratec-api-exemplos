package br.com.serratec.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.livraria.dto.LivroCadastroDto;
import br.com.serratec.livraria.dto.LivroDto;
import br.com.serratec.livraria.dto.RelatorioDto;
import br.com.serratec.livraria.model.Autor;
import br.com.serratec.livraria.model.Editora;
import br.com.serratec.livraria.model.Livro;
import br.com.serratec.livraria.repository.AutorRepository;
import br.com.serratec.livraria.repository.EditoraRepository;
import br.com.serratec.livraria.repository.LivroRepository;
import jakarta.validation.Valid;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repositorio;

	@Autowired
	private AutorRepository autorRepositorio;

	@Autowired
	private EditoraRepository editoraRepository;

	public List<LivroDto> obterTodos() {
		return repositorio.findAll().stream().map(l -> LivroDto.toDto(l)).toList();
		//return repositorio.buscaPorAnoLancamentoMenor(2015).stream().map(l -> LivroDto.toDto(l)).toList();
		//return repositorio.buscaPorEditoraId(1L).stream().map(l -> LivroDto.toDto(l)).toList();
		
//		Optional<Autor> autor = autorRepositorio.findById(1L);
//		return repositorio.buscaPorAutor(autor.get()).stream().map(l -> LivroDto.toDto(l)).toList();
	
	}

	public LivroDto gravarLivro(LivroCadastroDto livro) {
		Livro livroEntity = livro.toEntity();
		try {
			Optional<Editora> editora = editoraRepository.findById(livro.editoraId());
			livroEntity.setEditora(editora.get());	
		} catch (NoSuchElementException ex) {
		  throw new IllegalArgumentException("Id da editora é inválido");	
		}
		
		List<Autor> autores = new ArrayList<>();
		
		try {
			for (Long autorId : livro.autoresId()) {
				Optional<Autor> autor = autorRepositorio.findById(autorId);
					autores.add(autor.get());	
			}
			livroEntity.setAutores(autores);
		} catch (NoSuchElementException ex) {
			  throw new IllegalArgumentException("Id do autor é inválido");
		}	  
		repositorio.save(livroEntity);
		return LivroDto.toDto(livroEntity);
	}

	public LivroDto cadastraLivro(LivroDto livro) {
		Livro livroEntity = repositorio.save(livro.toEntity());
		return LivroDto.toDto(livroEntity);
	}

	public Optional<LivroDto> obterLivroPorId(Long id) {
		Optional<Livro> livroEntity = repositorio.findById(id);
		if (livroEntity.isEmpty()) {
			return Optional.of(LivroDto.toDto(livroEntity.get()));
		}
		return Optional.empty();
	}

	public Optional<LivroDto> atualizarLivro(Long id, @Valid LivroDto livro) {
		if (repositorio.existsById(id)) {
			Livro livroEntity = livro.toEntity();
			livroEntity.setId(id);
			repositorio.save(livroEntity);
			return Optional.of(LivroDto.toDto(livroEntity));
		}
		return Optional.empty();
	}

	public boolean excluirLivro(Long id) {
		Optional<Livro> livro = repositorio.findById(id);
		
		if(livro.isEmpty()){
			return false;
		}
		
		livro.get().getAutores().clear();
		repositorio.save(livro.get());
		repositorio.excluirLivro(id);
		return true;
	}

	public List<RelatorioDto> obterRelatorio() {
		List<RelatorioDto> relatorios = new ArrayList<>();
		List<Object[]> resultados = repositorio.buscarLivrosEditorasAutores();
	
		for (Object[] resultado : resultados) {
            relatorios.add(new RelatorioDto(
                (String) resultado[0],         // título
                (Integer) resultado[1],        // ano de lançamento
                (String) resultado[2],         // editora
                (String) resultado[3]          // autor
            ));
        }
		
		return relatorios;
	}

}
