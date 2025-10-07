package com.overdaily.Overdaily.Service;

import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class OverdleService {

    PersonagemRepository personagemRepository;
    Personagem personagem;


    public Optional<Personagem> PersonagemOFTD (){
        Long id;
        Random NumeroRandom = new Random();
        id = NumeroRandom.nextLong(personagemRepository.count());
        System.out.println(id);
        Personagem personagemdodia =new Personagem();
        personagemdodia.setId(id);

        return personagemRepository.findById(personagemdodia.getId());
    }

}
