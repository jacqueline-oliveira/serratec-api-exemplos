package br.com.serratec.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.serratec.livraria.model.Autor;
import br.com.serratec.livraria.model.Livro;
import jakarta.transaction.Transactional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = """
			   SELECT 
                l.titulo AS titulo, 
                l.ano_lancamento AS anoLancamento, 
                e.nome AS editora,
                STRING_AGG(a.nome, ', ') AS autor
            FROM 
                livros l
            JOIN 
                editoras e ON l.editora_id = e.id
            LEFT JOIN 
                livro_autor la ON la.livro_id = l.id
            LEFT JOIN 
                autores a ON la.autor_id = a.id
            GROUP BY 
                l.titulo, l.ano_lancamento, e.nome
            """, nativeQuery = true)
	List<Object[]> buscarLivrosEditorasAutores();
	
	//Excluir livro por id
	@Modifying
    @Transactional
	@Query("Delete from Livro l where l.id =:idLivro")
	void excluirLivro(@Param("idLivro") Long idLivro);
	
	//Selecionar livros cujo ano de lançamento seja menor ou igual ao passado por parâmetro 
	@Query("Select l from Livro l where l.anoLancamento <= :ano")
	List<Livro> buscaPorAnoLancamentoMenor(@Param("ano") int ano);
	
	//Selecionar livros usando o id da editora
	@Query("Select l from Livro l where l.editora.id = :editoraId")
	List<Livro> buscaPorEditoraId(@Param("editoraId") Long editoraId);
	
	//Selecionar livros por autor usando o próprio objeto Autor
	@Query("Select l from Livro l where :autor member of l.autores")
	List<Livro> buscaPorAutor(@Param("autor") Autor autor);
	
	
	
	
}