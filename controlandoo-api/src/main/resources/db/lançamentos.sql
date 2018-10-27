CREATE TABLE lancamento (
    idLancamento BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR (50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(100),
    tipo VARCHAR(20) NOT NULL,
    codigo_categoria BIGINT(20) NOT NULL,
    id_pessoa_pessoa BIGINT (20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
    FOREIGN KEY (id_pessoa_pessoa) REFERENCES pessoa(id_pessoa)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


