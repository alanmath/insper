package com.projeto.insper.controllers;


import com.projeto.insper.entities.Mensagem;
import com.projeto.insper.entities.MensagemArquivo;
import com.projeto.insper.entities.MensagemTexto;
import com.projeto.insper.services.MensagemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @Autowired
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping
    public List<Mensagem> listarMensagens() {
        return mensagemService.listarTodas();
    }

    @PostMapping("/Text")
    public MensagemTexto adicionarMensagemText(@RequestBody MensagemTexto novaMensagemText) {
        mensagemService.adicionarMensagemTexto(novaMensagemText);
        return novaMensagemText;
    }

    @PostMapping("/Arquivo")
    public MensagemArquivo adicionarMensagemArquivo(@RequestBody MensagemArquivo novaMensagemArquivo) {
        mensagemService.adicionarMensagemArquivo(novaMensagemArquivo);
        return novaMensagemArquivo;
}

    @GetMapping("/{userId}/user")
    public List<Mensagem> listarMensagensUsuario(@PathVariable("userId") String userId) {
        List<Mensagem> mensagens = mensagemService.listarMensagensUsuario(userId);
        return (mensagens);
    }

    @GetMapping("/{id}")
    public Mensagem buscarMensagem(@PathVariable("id") String id) {
        Mensagem mensagem = mensagemService.buscarMensagem(id);
        return mensagem;
    }
}