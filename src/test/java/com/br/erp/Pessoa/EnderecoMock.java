package com.br.erp.Pessoa;

import com.br.erp.pessoa.dto.EnderecoDto;
import com.br.erp.pessoa.model.Endereco;

public class EnderecoMock {

    public static Endereco mockEnderecoEntity() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345678");
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero(999);
        endereco.setComplemento("Apto 33");
        endereco.setIdCidade(44);
        endereco.setCidade("ExemploCity");
        endereco.setBairro("Centro");
        endereco.setIdEstado(77);
        endereco.setEstado("Mato");
        return endereco;
    }

    public static EnderecoDto mockEnderecoDto() {
        return new EnderecoDto(
            "12345678",
            "Rua Teste",
            999,
            "Apto 33",
            44,
            "ExemploCity",
            "Centro",
            77,
            "Mato"
        );
    }
}
