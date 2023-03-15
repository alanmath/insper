package com.projeto.insper.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.insper.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}