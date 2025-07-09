package com.br.erp.pessoa.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(
    @NotBlank(message = "CEP é obrigatório") String cep,
    String logradouro,
    int numero,
    String complemento,
    int idCidade,
    String cidade,
    String bairro,
    int idEstado,
    String estado
) {}
