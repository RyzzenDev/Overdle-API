package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.*;
import com.overdaily.Overdaily.model.*;
import lombok.Builder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OverdleService {

    private final ArmaRepository armaRepository;
    private final Arma armaDoDia;
    private final FalaRepository falaRepository;
    private final Fala falaDoDia;
    private final HabilidadeRepository habilidadeRepository;
    private final Habilidade habilidadeDoDia;
    private final MapaRepository mapaRepository;
    private final Mapa mapaDoDia;
    private final PersonagemRepository personagemRepository;
    private final Personagem personagemDoDia;


    public OverdleService(PersonagemRepository personagemRepository, ArmaRepository armaRepository, FalaRepository falaRepository, HabilidadeRepository habilidadeRepository, MapaRepository mapaRepository) {
        this.personagemRepository = personagemRepository;
        this.personagemDoDia = new Personagem();
        this.armaRepository = armaRepository;
        this.armaDoDia = new Arma();
        this.falaRepository = falaRepository;
        this.falaDoDia = new Fala();
        this.habilidadeRepository = habilidadeRepository;
        this.habilidadeDoDia = new Habilidade();
        this.mapaRepository = mapaRepository;
        this.mapaDoDia = new Mapa();

    }

    public Optional<Personagem> PersonagemOFTD() {
        Random NumeroRandom = new Random();
        int totalPersonagens = (int) personagemRepository.count();
        int id = NumeroRandom.nextInt(totalPersonagens) + 1;
        personagemDoDia.setId(id);
        return personagemRepository.findById(personagemDoDia.getId());
    }

    public Optional<Arma> ArmaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt((int) armaRepository.count());
        armaDoDia.setId(id);
        return armaRepository.findById(armaDoDia.getId());
    }

    public Optional<Habilidade> HabilidadeOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        habilidadeDoDia.setId(id);
        return habilidadeRepository.findById(habilidadeDoDia.getId());
    }

    public Optional<Fala> FalaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        falaDoDia.setId(id);
        return falaRepository.findById(falaDoDia.getId());
    }

    public Optional<Mapa> MapaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        mapaDoDia.setId(id);
        return mapaRepository.findById(mapaDoDia.getId());
    }

    public Optional<Personagem> TrazerPersonagem() {
        return personagemRepository.findById(personagemDoDia.getId());
    }

    public Optional<Arma> TrazerArma() {
        return armaRepository.findById(armaDoDia.getId());

    }

    public Optional<Habilidade> TrazerHabilidade() {
        return habilidadeRepository.findById(habilidadeDoDia.getId());
    }

    public Optional<Fala> TrazerFala() {
        return falaRepository.findById(falaDoDia.getId());
    }

    public Optional<Mapa> TrazerMapa() {
        return mapaRepository.findById(mapaDoDia.getId());
    }

    public String checkName(int guessedHero) {
    String check;
    String guessedName = personagemRepository.findById(guessedHero).get().getNomeAgente();
    String correctName = personagemRepository.findById(personagemDoDia.getId()).get().getNomeAgente();

    if (guessedName.equals(correctName)) {
        check = "Correct";
    } else {
        check = "Wrong";
    }
    return check;

    }

    public String checkGender(int guessedHero){
        String check;
        String guessedGender = personagemRepository.findById(guessedHero).get().getGeneroAgente();
        String correctGender = personagemRepository.findById(personagemDoDia.getId()).get().getGeneroAgente();
        if (guessedGender.equals(correctGender)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkHealth(int guessedHero){
        String check;
        int guessedHealth = personagemRepository.findById(guessedHero).get().getVidaAgente();
        int correctHealth = personagemRepository.findById(personagemDoDia.getId()).get().getVidaAgente();
        if (guessedHealth == correctHealth) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkAge(int guessedHero) {
        int GuessedHeroAge = personagemRepository.findById(guessedHero).get().getIdadeAgente();
        int CorrectHeroAge = personagemRepository.findById(personagemDoDia.getId()).get().getIdadeAgente();
        String Check;

        if (GuessedHeroAge == CorrectHeroAge) {
            Check = "Correct";
        } else if (GuessedHeroAge < CorrectHeroAge) {
            Check = "Younger";
        }else {
            Check = "Older";
        }
        return Check;
    }

    public String checkRole(int guessedHero) {
        String guessedRole = personagemRepository.findById(guessedHero).get().getTipoAgente();
        String correctRole = personagemRepository.findById(personagemDoDia.getId()).get().getTipoAgente();
        String check;

        if (guessedRole.equals(correctRole)) {
             check = "Correct";
        }
        else {
             check = "Wrong";
        }
        return check;
    }

    public String checkAffiliation(int guessedHero) {
        String Check;
        String GuessedAffiliation = personagemRepository.findById(guessedHero).get().getAfiliacaoAgente();
        String CorrectAffiliation = personagemRepository.findById(personagemDoDia.getId()).get().getAfiliacaoAgente();
            if (GuessedAffiliation.equals(CorrectAffiliation)) {
                Check = "Correct";
            }
            else {
                Check = "Younger";
            }
        return Check;

            }

    public ServerGuessResponseDTO checkTotal(int guessedHero){


        String checkName = checkName(guessedHero);
        String checkGender = checkGender(guessedHero);
        String checkHealth = checkHealth(guessedHero);
        String checkAge = checkAge(guessedHero);
        String checkRole =checkRole(guessedHero);
        String checkAffiliation = checkAffiliation(guessedHero);


       return ServerGuessResponseDTO.builder()
               .name(checkName)
               .gender(checkGender)
               .health(checkHealth)
               .role(checkRole)
               .age(checkAge)
               .affiliation(checkAffiliation)
               .build();

    }
}




