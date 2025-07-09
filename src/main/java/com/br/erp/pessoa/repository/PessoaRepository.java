package com.br.erp.pessoa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.erp.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
