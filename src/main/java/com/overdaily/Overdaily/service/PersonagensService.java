package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.Repository.PersonagensRepository;
import com.overdaily.Overdaily.model.Personagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagensService {

    @Autowired
    private PersonagensRepository personagensRepository;

    public Optional<Personagens> findById(Short id) {
        return personagensRepository.findById(id);
    }

    public List<Personagens> pegarTodos() {
        return personagensRepository.findAll();
    }

    public List<Personagens> getPersonagensByTipoAgente(String tipoAgente) {
        return personagensRepository.findByTipoAgente(tipoAgente);
    }

}

