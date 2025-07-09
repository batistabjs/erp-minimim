CREATE TABLE pessoa (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(1) NOT NULL,
    cnpj VARCHAR(20), 
    cpf VARCHAR(20) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    celular VARCHAR(20),
    telefone VARCHAR(20),
    email VARCHAR(255)
);