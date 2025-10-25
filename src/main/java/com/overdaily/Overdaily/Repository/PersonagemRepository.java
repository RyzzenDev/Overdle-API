package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository <Personagem, Integer>{

    Optional<Personagem> findById(Integer Id);
    List<Personagem> findAll();
}
