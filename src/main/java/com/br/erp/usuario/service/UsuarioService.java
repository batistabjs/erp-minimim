package com.br.erp.usuario.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.erp.usuario.model.Usuario;
import com.br.erp.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> autenticar(String username, String password) {
        Optional<Usuario> optUser = usuarioRepository.findByUsername(username);
        if (optUser.isPresent() && passwordEncoder.matches(password, optUser.get().getPassword())) {
            return optUser;
        }
        return Optional.empty();
    }
}
