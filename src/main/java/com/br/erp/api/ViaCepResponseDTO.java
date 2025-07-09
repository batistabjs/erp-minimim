package com.br.erp.api;

public record ViaCepResponseDTO(String cep, String logradouro, String uf, String ibge, String erro) {

    public String getErro() { return erro; }
}
