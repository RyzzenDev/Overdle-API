package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class OverdleService {

    private final PersonagemRepository personagemRepository;

    private  Personagem personagemDoDia;

    public OverdleService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
        this.personagemDoDia = new Personagem();
    }

    public Optional<Personagem> PersonagemOFTD (){
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        personagemDoDia.setId(id);
        return personagemRepository.findById(personagemDoDia.getId());
    }

    public Optional<Personagem> CompareIdade(){


        return null;
    }





}
