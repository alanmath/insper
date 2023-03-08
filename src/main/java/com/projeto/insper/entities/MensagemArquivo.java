package com.projeto.insper.entities;

public class MensagemArquivo extends Mensagem {
    private String arquivo;
    private String id;

    public MensagemArquivo(String arquivo, String destinatario, String autor) {
        super(arquivo, destinatario, autor);
        this.arquivo = arquivo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
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