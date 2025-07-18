package com.br.erp.usuario.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.erp.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
