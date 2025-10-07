package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository <Personagem, Long>{
    //aqui todo repository sem excessao tem que ser uma INTERFACE por causa q ela extende JpaRepository
    //no extends JpaRepository<Personagens, Short>  O PERSONAGENS VAI SER O OBJETO (CHAVE) o Short vai ser o value (id)
    //vc pode puxar por qualquer parametro que conter no seu modelo, nome, id, etc...

    Optional<Personagem> findById(Long id);
    List<Personagem> findAll();
    List<Personagem> findByNomeRealAgente(String nomeRealAgente);
    List<Personagem> findByTipoAgente(String tipoAgente);
    List<Personagem> findByPaisAgente(String paisAgente);


}
