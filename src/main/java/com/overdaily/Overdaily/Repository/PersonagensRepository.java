package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Personagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagensRepository extends JpaRepository <Personagens, Short>{
    //aqui todo repository sem excessao tem que ser uma INTERFACE por causa q ela extende JpaRepository
    //no extends JpaRepository<Personagens, Short>  O PERSONAGENS VAI SER O OBJETO (CHAVE) o Short vai ser o value (id)
    //vc pode puxar por qualquer parametro que conter no seu modelo, nome, id, etc...

    Optional<Personagens> findById(Short id);
    List<Personagens> findAll();
    List<Personagens> findByNomeRealAgente(String nomeRealAgente);
    List<Personagens> findByTipoAgente(String tipoAgente);
    List<Personagens> findByPaisAgente(String paisAgente);
    findBy

}
