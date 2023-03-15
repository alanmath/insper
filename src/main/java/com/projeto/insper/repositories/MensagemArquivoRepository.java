package com.projeto.insper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.insper.entities.MensagemArquivo;

public interface MensagemArquivoRepository extends JpaRepository<MensagemArquivo, Long> {
}