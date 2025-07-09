package com.br.erp.Pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.br.erp.pessoa.dto.EnderecoDto;
import com.br.erp.pessoa.dto.PessoaCadastroRequest;
import com.br.erp.pessoa.dto.PessoaListResponse;
import com.br.erp.pessoa.model.Endereco;
import com.br.erp.pessoa.model.Pessoa;
import com.br.erp.pessoa.repository.PessoaRepository;
import com.br.erp.pessoa.service.PessoaService;

public class PessoaServiceTest {

    private PessoaService pessoaService;
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        pessoaRepository = Mockito.mock(PessoaRepository.class);
        pessoaService = new PessoaService(pessoaRepository);
    }

    @Test
    public void testCadastroOk() {
        EnderecoDto enderecoDto = new EnderecoDto(
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

        // PessoaCadastroRequest dto = PessoaCadastroRequest with {
        //     'F', "", "12345678900", "Maria Teste",
        //     "11999998888", "1122334455", "maria@email.com",
        //     enderecoDto };

        // // Entidade simulada a ser retornada
        // Pessoa pessoaSalva = new Pessoa(
        //     dto.tipo(), dto.cnpj(), dto.cpf(), dto.nome(), dto.celular(),
        //     dto.telefone(), dto.email(),
        //     EnderecoMock.mockEnderecoEntity()
        // );
        // pessoaSalva.setId(1L);

        // when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaSalva);

        // PessoaListResponse result = pessoaService.novo(dto);

        // Verificação de todos os novos campos de endereço!
        // EnderecoDto enderecoResult = result.endereco();
        // assertNotNull(enderecoResult);
        // assertEquals("12345678", enderecoResult.cep());
        // assertEquals("Rua Teste", enderecoResult.logradouro());
        // assertEquals(999, enderecoResult.numero());
        // assertEquals("Apto 33", enderecoResult.complemento());
        // assertEquals(44, enderecoResult.idCidade());
        // assertEquals("ExemploCity", enderecoResult.cidade());
        // assertEquals("Centro", enderecoResult.bairro());
        // assertEquals(77, enderecoResult.idEstado());
        // assertEquals("Mato", enderecoResult.estado());
    }
}
