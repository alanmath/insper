package com.projeto.insper.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "mensagem_arquivo")
public class MensagemArquivo extends Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String Arquivo = "";
    private String identifier = "";

    public String getArquivo() {
        return Arquivo;
    }

    public void setArquivo(String texto) {
        this.Arquivo = texto;
    }

    public MensagemArquivo() {
        super();
    }

    public MensagemArquivo(String Arquivo, String destinatario, String autor, String identifier) {
        super(destinatario, autor);
        this.Arquivo = Arquivo;
        this.identifier = identifier;

    }


    public String setIdentifier (String identifier) {
        this.identifier = identifier;
        return this.identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}