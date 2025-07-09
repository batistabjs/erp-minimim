CREATE TABLE endereco (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cep VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(255),
    id_cidade INT,
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    id_estado INT,
    estado VARCHAR(100)
);
