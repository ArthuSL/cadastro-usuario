package com.java.aula.cadastro_usuario.infrastructure.repository;

import com.java.aula.cadastro_usuario.infrastructure.entitys.Animal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Optional<Animal> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
