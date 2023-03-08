package com.projeto.insper.entities;


public class Mensagem {
    // associe a classe mensagem a pessoa
    private String texto;
    public String destinatario;
    private String remetente;

    public Mensagem(String texto, String destinatario, String autor) {
        this.texto = texto;
        this.destinatario = destinatario;
        this.remetente = autor;
    }

}