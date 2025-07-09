package com.br.erp.pessoa.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.erp.api.ViaCep;
import com.br.erp.api.ViaCepResponseDTO;
import com.br.erp.exception.NotFoundException;
import com.br.erp.pessoa.dto.EnderecoDto;
import com.br.erp.pessoa.dto.PessoaCadastroRequest;
import com.br.erp.pessoa.dto.PessoaListResponse;
import com.br.erp.pessoa.model.Endereco;
import com.br.erp.pessoa.model.Pessoa;
import com.br.erp.pessoa.proto.PessoaProto;
import com.br.erp.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private ViaCep viaCep;
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaListResponse salvar(PessoaCadastroRequest pessoaCadastroRequest) {
        validarDados(pessoaCadastroRequest);
        
        Endereco endereco = new Endereco(
            pessoaCadastroRequest.endereco().cep(),
            pessoaCadastroRequest.endereco().logradouro(),
            pessoaCadastroRequest.endereco().numero(),
            pessoaCadastroRequest.endereco().complemento(),
            pessoaCadastroRequest.endereco().idCidade(),
            pessoaCadastroRequest.endereco().cidade(),
            pessoaCadastroRequest.endereco().bairro(),
            pessoaCadastroRequest.endereco().idEstado(),
            pessoaCadastroRequest.endereco().estado()
        );

        Pessoa pessoa = new Pessoa(
                pessoaCadastroRequest.tipo(),
                pessoaCadastroRequest.cnpj(),
                pessoaCadastroRequest.cpf(),
                pessoaCadastroRequest.nome(),
                pessoaCadastroRequest.celular(),
                pessoaCadastroRequest.telefone(),
                pessoaCadastroRequest.email(),
                endereco
        );
        Pessoa saved = pessoaRepository.save(pessoa);

        return new PessoaListResponse(
                saved.getId(),
                saved.getTipo(),
                saved.getCnpj(),
                saved.getCpf(),
                saved.getNome(),
                saved.getCelular(),
                saved.getTelefone(),
                saved.getEmail(),
                new EnderecoDto(
                    saved.getEndereco().getCep(),
                    saved.getEndereco().getLogradouro(),
                    saved.getEndereco().getNumero(),
                    saved.getEndereco().getComplemento(),
                    saved.getEndereco().getIdCidade(),
                    saved.getEndereco().getCidade(),
                    saved.getEndereco().getBairro(),
                    saved.getEndereco().getIdEstado(),
                    saved.getEndereco().getEstado()
                )
            );
    }

    public List<PessoaListResponse> listAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(p ->
                        new PessoaListResponse(
                                p.getId(),
                                p.getTipo(),
                                p.getCnpj(),
                                p.getCpf(),
                                p.getNome(),
                                p.getCelular(),
                                p.getTelefone(),
                                p.getEmail(),
                                new EnderecoDto(
                                    p.getEndereco().getCep(),
                                    p.getEndereco().getLogradouro(),
                                    p.getEndereco().getNumero(),
                                    p.getEndereco().getComplemento(),
                                    p.getEndereco().getIdCidade(),
                                    p.getEndereco().getCidade(),
                                    p.getEndereco().getBairro(),
                                    p.getEndereco().getIdEstado(),
                                    p.getEndereco().getEstado()
                                )
                        )
                ).toList();
    }

    public PessoaProto.PessoaList listProto() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        PessoaProto.PessoaList.Builder pessoaProtoBuilder = PessoaProto.PessoaList.newBuilder();

        pessoaList.forEach(pessoa -> pessoaProtoBuilder.addPessoa(
            PessoaProto.Pessoa.newBuilder()
                .setId(pessoa.getId())
                .setTipo(pessoa.getTipo())
                .setCnpj(pessoa.getCnpj())
                .setCpf(pessoa.getCpf())
                .setNome(pessoa.getNome())
                .setCelular(pessoa.getCelular())
                .setTelefone(pessoa.getTelefone())
                .setEmail(pessoa.getEmail())
                .setEndereco(
                   PessoaProto.Endereco.newBuilder()
                   .setId(pessoa.getEndereco().getId())
                   .setCep(pessoa.getEndereco().getCep())
                   .setLogradouro(pessoa.getEndereco().getLogradouro())
                   .setNumero(pessoa.getEndereco().getNumero())
                   .setComplemento(pessoa.getEndereco().getComplemento())
                   .setIdCidade(pessoa.getEndereco().getIdCidade())
                   .setCidade(pessoa.getEndereco().getCidade())
                   .setIdEstado(pessoa.getEndereco().getIdEstado())
                   .setEstado(pessoa.getEndereco().getEstado()))
        ));

        return pessoaProtoBuilder.build();
    }

    public void removeById(Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Pessoa codigo " + id + " não encontrada.");
        }
    }

    private Boolean validarDados(PessoaCadastroRequest pessoaCadastroRequest) {
        if (Objects.equals(pessoaCadastroRequest.tipo(), "J") 
        && (Objects.isNull(pessoaCadastroRequest.cnpj()) || pessoaCadastroRequest.cnpj().isEmpty())) {
            throw new NotFoundException("CNPJ deve ser informado");
        }
        
        ViaCepResponseDTO viaCepResponse = viaCep.consultaCep(pessoaCadastroRequest.endereco().cep());

        if (Objects.isNull(viaCepResponse) || !Objects.isNull(viaCepResponse.getErro())) {
           throw new NotFoundException("CEP não encontrado!");
        } else if (!Objects.equals(String.valueOf(pessoaCadastroRequest.endereco().idCidade()), viaCepResponse.ibge())) {
           throw new NotFoundException("Codigo idCidade não encontrado!");
        }
        
        return true;
    }
}
