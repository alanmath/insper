package com.projeto.insper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projeto.insper.entities.Usuario;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    
    public void cadastrarUsuario(Usuario usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuarios.add(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return (usuarios);
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }


}