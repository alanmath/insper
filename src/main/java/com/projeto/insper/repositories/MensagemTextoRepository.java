package com.projeto.insper.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.insper.entities.MensagemTexto;

public interface MensagemTextoRepository extends JpaRepository<MensagemTexto, Long> {
}