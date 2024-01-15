/* Remover em produção */
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS clientes;
/* Remover em produção */

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE,
    nome VARCHAR(255),
    foto VARCHAR(550),
    senha VARCHAR(255),
    acesso VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255),
    cnpj_cpf VARCHAR(20),
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
    fornecedor VARCHAR(255),
    foto VARCHAR(550),
    nome VARCHAR(255),
    codigo VARCHAR(50),
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

