package com.projeto.insper.services;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.insper.entities.Usuario;
import com.projeto.insper.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public void cadastrarUsuario(Usuario usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return (usuarioRepository.findAll());
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario usuario : listarUsuarios()) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : listarUsuarios()) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }


}