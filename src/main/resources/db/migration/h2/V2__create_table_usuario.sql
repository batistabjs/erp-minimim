CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO usuario (username, password)
VALUES ('brunobatista', '$2a$12$C15948G6idP3o6ZdvNP/ieFuB5skvTVCoefEf/HKrcol6TLELKKHu');