CREATE TABLE autores (
	id serial primary key,
	nome varchar(255),
	logradouro varchar(255),
	numero varchar(5),
	complemento varchar(100),
	cep varchar(10)
);

CREATE TABLE livros (
	id serial primary key,
	titulo varchar(255),
	isbn varchar(20),
	ano_lancamento integer,
	editora_id bigint,
	CONSTRAINT editoras_fk FOREIGN KEY (editora_id)
		REFERENCES editoras (id)
);

CREATE TABLE livro_autor (
  livro_id bigint,
  autor_id bigint,
  CONSTRAINT livro_fk FOREIGN KEY (livro_id)
  	REFERENCES livros (id),
  CONSTRAINT autor_fk FOREIGN KEY (autor_id)
  	REFERENCES autores (id)	
);

