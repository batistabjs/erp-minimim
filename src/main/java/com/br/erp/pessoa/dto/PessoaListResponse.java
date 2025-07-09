package com.br.erp.pessoa.dto;

public record PessoaListResponse(
    Long id,
    String tipo,
    String cnpj,
    String cpf,
    String nome,
    String celular,
    String telefone,
    String email,
    EnderecoDto endereco) {
}
