package com.projeto.insper.entities;

import java.util.List;

public class  Usuario {
    private String nome = "";
    private String cpf;
    private String id;
    public List<MensagemTexto> mensagensTexto;
    public List<MensagemArquivo> mensagensArquivo;


    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String setId (String id) {
        this.id = id;
        return this.id;
    }
    public String getId() {
        return this.id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}