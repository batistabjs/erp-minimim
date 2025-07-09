package com.br.erp.pessoa.dto;

import jakarta.validation.constraints.NotBlank;

public record PessoaCadastroRequest(
    @NotBlank(message = "Tipo Pessoa Fisica ou Juridica é obrigatório") String tipo,
    String cnpj,
    @NotBlank(message = "CPF é obrigatório") String cpf,
    @NotBlank(message = "Nome é obrigatório") String nome,
    String celular,
    String telefone,
    String email,
    EnderecoDto endereco) {  
}
    