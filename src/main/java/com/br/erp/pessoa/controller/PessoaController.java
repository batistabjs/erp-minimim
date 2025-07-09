package com.br.erp.pessoa.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.erp.pessoa.dto.PessoaCadastroRequest;
import com.br.erp.pessoa.dto.PessoaListResponse;
import com.br.erp.pessoa.proto.PessoaProto;
import com.br.erp.pessoa.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService service) { this.pessoaService = service; }

    @GetMapping("/list")
    public List<PessoaListResponse> listAll() { return pessoaService.listAll(); }

    @GetMapping("/listbyPage")
    public Page<PessoaListResponse> listar(@ParameterObject Pageable pageable) {
        return pessoaService.listarPage(pageable);
    }

    @GetMapping(value = "/listbyProto", produces = "application/x-protobuf")
    public PessoaProto.PessoaList listarProto() { return pessoaService.listProto(); }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid PessoaCadastroRequest dto) {
        return ResponseEntity.ok(pessoaService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
