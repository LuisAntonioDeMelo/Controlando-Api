CREATE TABLE pessoa (
    idPessoa BIGINT(30) PRIMARY KEY auto_increment,
    nome varchar(80) NOT NULL,
    ativo boolean,
    logradouro varchar(80),
    numero varchar(10),
    complemento varchar(60),
    bairro varchar(60),
    cep varchar (21),
    cidade varchar(60),
    estado varchar(80)
)
engine= InnoDB default charset=utf8;