CREATE TABLE registros (
   id serial primary key,
   alvara varchar(20),
   cnpj varchar(20),
   data_autorizacao date
);

CREATE TABLE editoras (
  id serial primary key,
  nome varchar(255),
  registro_id bigint,
  CONSTRAINT registro_fk FOREIGN KEY (registro_id)
     REFERENCES registros (id)
     );