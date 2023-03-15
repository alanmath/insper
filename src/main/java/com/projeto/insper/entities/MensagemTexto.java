package com.projeto.insper.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mensagem_texto")
@AttributeOverride(name = "autor", column = @Column(name = "autor_texto"))
@AttributeOverride(name = "destinatario", column = @Column(name = "destinatario_texto"))
public class MensagemTexto extends Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String texto = "";
    private String identifier = "";

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public MensagemTexto() {
        super();
    }

    public MensagemTexto(String texto, String destinatario, String autor, String identifier) {
        super(destinatario, autor);
        this.texto = texto;
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