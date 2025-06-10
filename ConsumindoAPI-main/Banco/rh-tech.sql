Create database rh_tech;
use rh_tech;

CREATE TABLE funcionarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL
);

CREATE TABLE cargos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE funcionarios_por_cargos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    funcionario_id BIGINT NOT NULL,
    cargo_id BIGINT NOT NULL,
    detalhes VARCHAR(255),
    data_inicio DATE NOT NULL,
    data_fim DATE,

    FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id) ON DELETE CASCADE,
    FOREIGN KEY (cargo_id) REFERENCES cargos(id) ON DELETE CASCADE
);