package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository <Personagem, Integer>{
    //REPOSITORIO DO REDIS
    @Query("SELECT p FROM Personagem p " +
            "LEFT JOIN FETCH p.armaAgente " +
            "LEFT JOIN FETCH p.falasAgente " +
            "LEFT JOIN FETCH p.habilidadeAgente")
    List<Personagem> findAllWithDetails();
    //REPOSITORIO DO REDIS

    Optional<Personagem> findById(Integer Id);
    List<Personagem> findAll();
}
