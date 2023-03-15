package com.projeto.insper.entities;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Mensagem {
    // associe a classe mensagem a pessoa
    public String destinatario;
    public String autor;

    public Mensagem() {
    }
    public Mensagem(String destinatario, String autor) {
        this.destinatario = destinatario;
        this.autor = autor;
    }
}