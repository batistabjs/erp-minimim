package com.br.erp.pessoa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    private String complemento;

    private int idCidade;

    private String cidade;

    private String bairro;

    private int idEstado;

    private String estado;

    // Getters e setters

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, int numero, String complemento,
                    int idCidade, String cidade, String bairro, int idEstado, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.idCidade = idCidade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public int getIdCidade() { return idCidade; }
    public void setIdCidade(int idCidade) { this.idCidade = idCidade; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
