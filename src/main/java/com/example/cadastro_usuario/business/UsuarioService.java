package com.example.cadastro_usuario.business;

import com.example.cadastro_usuario.infrastructure.entitys.Usuario;
import com.example.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){

        this.repository = repository;

    }

    public void salvarUsuario(Usuario usuario){

        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );

    }

    public void deleteUsuarioPorEmail(String email){
        repository.deleteByEmail(email);

    }



}
