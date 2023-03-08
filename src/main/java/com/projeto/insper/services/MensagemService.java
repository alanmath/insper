package com.projeto.insper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.insper.entities.Mensagem;
import com.projeto.insper.entities.MensagemArquivo;
import com.projeto.insper.entities.MensagemTexto;
import com.projeto.insper.entities.Usuario;


@Service
public class MensagemService {
    private List<MensagemTexto> listaMensagensTexto = new ArrayList<>();
    private List<MensagemArquivo> listaMensagensArquivo = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;


    public List<Mensagem> listarTodas() {

        List<Mensagem> listaMensagens = new ArrayList<>();


        for (Mensagem mensagem : listaMensagensTexto) {
            listaMensagens.add(mensagem);
        }
        for (Mensagem mensagem : listaMensagensArquivo) {
            listaMensagens.add(mensagem);
        }
        return listaMensagens;
    }

    public void adicionarMensagemTexto(MensagemTexto novaMensagem) {
        if (usuarioService.buscarUsuarioPorNome(novaMensagem.destinatario) != null) {
            novaMensagem.setId(UUID.randomUUID().toString());
            listaMensagensTexto.add(novaMensagem);

        }
        else {
            System.out.println("Usuário não encontrado");
        }
    }
    public void adicionarMensagemArquivo(MensagemArquivo novaMensagem) {
        if (usuarioService.buscarUsuarioPorNome(novaMensagem.destinatario) != null) {
            novaMensagem.setId(UUID.randomUUID().toString());
            listaMensagensArquivo.add(novaMensagem);

        }
        else {
            System.out.println("Usuário não encontrado");
        }
}

    public List<Mensagem> listarMensagensUsuario(String userId) {
        List<Mensagem> mensagens = new ArrayList<>();
        Usuario usuario = usuarioService.buscarUsuario(userId);

        
        for (Mensagem mensagem : listaMensagensTexto) {
            if (mensagem.destinatario.equals(usuario.getNome())) {
                mensagens.add(mensagem);
            }
        }
        for (Mensagem mensagem : listaMensagensArquivo) {
            if (mensagem.destinatario.equals(usuario.getNome())) {
                mensagens.add(mensagem);
            }
        }
        return mensagens;
    }

    public Mensagem buscarMensagem(String id) {
        for (MensagemTexto mensagem : listaMensagensTexto) {
            if (mensagem.getId().equals(id)) {
                return mensagem;
            }
        }
        for (MensagemArquivo mensagem : listaMensagensArquivo) {
            if (mensagem.getId().equals(id)) {
                return mensagem;
            }
        }
        return null;
    }
}
