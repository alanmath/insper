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
import com.projeto.insper.repositories.MensagemArquivoRepository;
import com.projeto.insper.repositories.MensagemTextoRepository;


@Service
public class MensagemService {

    @Autowired
    private MensagemArquivoRepository mensagemArquivoRepository;

    @Autowired
    private MensagemTextoRepository mensagemTextoRepository;

    @Autowired
    private UsuarioService usuarioService;


    public List<Mensagem> listarTodas() {
        List<Mensagem> listaMensagens = new ArrayList<>();

        for (Mensagem mensagem : mensagemArquivoRepository.findAll()) {
            listaMensagens.add(mensagem);
        }
        for (Mensagem mensagem : mensagemTextoRepository.findAll()) {
            listaMensagens.add(mensagem);
        }
        return listaMensagens;
    }

    public void adicionarMensagemTexto(MensagemTexto novaMensagem) {
        if (usuarioService.buscarUsuarioPorNome(novaMensagem.destinatario) != null) {
            novaMensagem.setIdentifier(UUID.randomUUID().toString());
            mensagemTextoRepository.save(novaMensagem);

        }
        else {
            System.out.println("Usuário não encontrado");
        }
    }
    public void adicionarMensagemArquivo(MensagemArquivo novaMensagem) {
        if (usuarioService.buscarUsuarioPorNome(novaMensagem.destinatario) != null) {
            novaMensagem.setIdentifier(UUID.randomUUID().toString());
            mensagemArquivoRepository.save(novaMensagem);

        }
        else {
            System.out.println("Usuário não encontrado");
        }
}

    public List<Mensagem> listarMensagensUsuario(String userId) {
        List<Mensagem> mensagens = new ArrayList<>();
        Usuario usuario = usuarioService.buscarUsuario(userId);

        
        for (Mensagem mensagem : mensagemTextoRepository.findAll()) {
            if (mensagem.destinatario.equals(usuario.getNome())) {
                mensagens.add(mensagem);
            }
        }
        for (Mensagem mensagem : mensagemArquivoRepository.findAll()) {
            if (mensagem.destinatario.equals(usuario.getNome())) {
                mensagens.add(mensagem);
            }
        }
        return mensagens;
    }

    public Mensagem buscarMensagem(String id) {
        for (MensagemTexto mensagem : mensagemTextoRepository.findAll()) {
            if (mensagem.getIdentifier().equals(id)) {
                return mensagem;
            }
        }
        for (MensagemArquivo mensagem : mensagemArquivoRepository.findAll()) {
            if (mensagem.getIdentifier().equals(id)) {
                return mensagem;
            }
        }
        return null;
    }
}
