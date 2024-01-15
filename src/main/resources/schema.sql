/* Remover em produção */
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS clientes;
/* Remover em produção */

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    foto VARCHAR(550),
    senha VARCHAR(255) NOT NULL,
    acesso VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cnpj_cpf VARCHAR(20) UNIQUE NOT NULL,
    estado VARCHAR(50),
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    cep VARCHAR(15),
    quadra VARCHAR(50),
    lote VARCHAR(50),
    telefone1 VARCHAR(20),
    telefone2 VARCHAR(20),
    status BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT,
    fornecedor VARCHAR(255) NOT NULL,
    foto VARCHAR(550),
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(50) NOT NULL,
    descricao TEXT,
    unidade_medida VARCHAR(50),
    tamanho VARCHAR(50),
    peso DECIMAL(10,2),
    largura DECIMAL(10,2),
    quantidade INT,
    valor DECIMAL(10,2),
    markup VARCHAR(50),
    valor_total DECIMAL(10,2),
    status BOOLEAN,
    PRIMARY KEY (id)
);

