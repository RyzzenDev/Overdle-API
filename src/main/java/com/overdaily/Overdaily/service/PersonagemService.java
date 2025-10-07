package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagensRepository;

    public Optional<Personagem> findById(Long id) {
        return personagensRepository.findById(id);

    }

    public List<Personagem> pegarTodos() {
        return personagensRepository.findAll();
    }

    public List<Personagem> getPersonagensByTipoAgente(String tipoAgente) {
        return personagensRepository.findByTipoAgente(tipoAgente);
    }

}

