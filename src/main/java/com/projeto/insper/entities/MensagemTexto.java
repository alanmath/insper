package com.projeto.insper.entities;

public class MensagemTexto extends Mensagem {
    private String texto;
    private String id;

    public MensagemTexto(String texto, String destinatario, String autor) {
        super(texto, destinatario, autor);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String setId (String id) {
        this.id = id;
        return this.id;
    }

    public String getId() {
        return this.id;
    }
}