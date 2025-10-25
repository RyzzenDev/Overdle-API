package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.exceptions.Personagem.NonExistentID;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class PersonagemService {


    private final PersonagemRepository personagensRepository;
    private final Personagem personagemDoDia;

    public PersonagemService(PersonagemRepository personagensRepository) {
        this.personagensRepository = personagensRepository;
        this.personagemDoDia = new Personagem();
    }

    public HeroSearchDTO SearchID(Integer id) {
        Personagem personagembuscado = personagensRepository.findById(id)
                .orElseThrow(()-> new NonExistentID(id));
        return new HeroSearchDTO(personagembuscado);
    }

    public List<ListHeroesDTO> IDList() {
        List<Personagem> HeroList = personagensRepository.findAll();
        return HeroList.stream()
                .map(ListHeroesDTO::new )
                .toList();
    }

    public List<ListHeroesDTO> SearchRole(String heroType){
        List<Personagem> HeroList = personagensRepository.findAll();

        List<ListHeroesDTO> ListaBuscada = new java.util.ArrayList<>();

        String heroRole = heroType.toLowerCase();


        switch (heroRole){
            case "tank":{
                List<ListHeroesDTO> RoleTankList = HeroList.stream()
                        .filter(personagem -> "Tank".equals(personagem.getTipoAgente()))
                        .map(ListHeroesDTO::new)
                        .toList();
                ListaBuscada = RoleTankList;

                return ListaBuscada;

            }
            case "damage":{
                List<ListHeroesDTO> RoleDamageList = HeroList.stream()
                        .filter(personagem -> "Damage".equals(personagem.getTipoAgente()))
                        .map(ListHeroesDTO::new)
                        .toList();
                ListaBuscada = RoleDamageList;

                return ListaBuscada;

            }
            case "support":{
                List<ListHeroesDTO> RoleSupportList = HeroList.stream()
                        .filter(personagem -> "Support".equals(personagem.getTipoAgente()))
                        .map(ListHeroesDTO::new)
                        .toList();
                ListaBuscada = RoleSupportList;
                return ListaBuscada;

            }
        }

        return ListaBuscada;
    }

    public String RandomizeID(){
        Random NumeroRandom = new Random();
        int totalPersonagens = (int) personagensRepository.count();
        int id = NumeroRandom.nextInt(totalPersonagens) + 1;
        personagemDoDia.setId(id);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);

        return " Hero Selected at: " +timeFormatted;
    }

    public String checkName(int guessedHero) {
        String check;
        String guessedName = personagensRepository.findById(guessedHero).get().getNomeAgente();
        String correctName = personagensRepository.findById(personagemDoDia.getId()).get().getNomeAgente();

        if (guessedName.equals(correctName)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkGender(int guessedHero){
        String check;
        String guessedGender = personagensRepository.findById(guessedHero).get().getGeneroAgente();
        String correctGender = personagensRepository.findById(personagemDoDia.getId()).get().getGeneroAgente();
        if (guessedGender.equals(correctGender)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkHealth(int guessedHero){
        String check;
        int guessedHealth = personagensRepository.findById(guessedHero).get().getVidaAgente();
        int correctHealth = personagensRepository.findById(personagemDoDia.getId()).get().getVidaAgente();
        if (guessedHealth == correctHealth) {
            check = "Correct";
        } else if (guessedHealth < correctHealth) {
            check = "More";
        } else {
            check = "Less";
        }
        return check;

    }

    public String checkAge(int guessedHero) {
        int GuessedHeroAge = personagensRepository.findById(guessedHero).get().getIdadeAgente();
        int CorrectHeroAge = personagensRepository.findById(personagemDoDia.getId()).get().getIdadeAgente();
        String Check;

        if (GuessedHeroAge == CorrectHeroAge) {
            Check = "Correct";
        } else if (GuessedHeroAge < CorrectHeroAge) {
            Check = "Older";
        }else {
            Check = "Younger";
        }
        return Check;
    }

    public String checkRole(int guessedHero) {
        String guessedRole = personagensRepository.findById(guessedHero).get().getTipoAgente();
        String correctRole = personagensRepository.findById(personagemDoDia.getId()).get().getTipoAgente();
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
        String GuessedAffiliation = personagensRepository.findById(guessedHero).get().getAfiliacaoAgente();
        String CorrectAffiliation = personagensRepository.findById(personagemDoDia.getId()).get().getAfiliacaoAgente();
        if (GuessedAffiliation.equals(CorrectAffiliation)) {
            Check = "Correct";
        }
        else {
            Check = "Wrong";
        }
        return Check;

    }

    public String checkComposition(int guessedHero){
        String check;
        String GuessedComposition = personagensRepository.findById(guessedHero).get().getCompAgente();
        String CorrectComposition = personagensRepository.findById(personagemDoDia.getId()).get().getCompAgente();
        if (GuessedComposition.equals(CorrectComposition)) {
            check = "Correct";
        }
        else {
            check = "Wrong";
        }

        return check;
    }

    public String checkLaunchYear(int guessedHero){
        String check;
        int GuessedLaunchYear = personagensRepository.findById(guessedHero).get().getAnoAgente();
        int CorrectLaunchYear = personagensRepository.findById(personagemDoDia.getId()).get().getAnoAgente();

        if (GuessedLaunchYear == CorrectLaunchYear) {
            check = "Correct";
        } else if (CorrectLaunchYear > GuessedLaunchYear) {
            check = "Later";

        }else
            check = "Earlier";

        return check;
    }

    public ServerGuessResponseDTO checkTotal(int guessedHero){


        String checkName = checkName(guessedHero);
        String checkGender = checkGender(guessedHero);
        String checkHealth = checkHealth(guessedHero);
        String checkAge = checkAge(guessedHero);
        String checkRole =checkRole(guessedHero);
        String checkAffiliation = checkAffiliation(guessedHero);
        String checkComposition = checkComposition(guessedHero);
        String checkLaunchYear = checkLaunchYear(guessedHero);


        return ServerGuessResponseDTO.builder()
                .name(checkName)
                .gender(checkGender)
                .health(checkHealth)
                .role(checkRole)
                .age(checkAge)
                .affiliation(checkAffiliation)
                .Composition(checkComposition)
                .LaunchYear(checkLaunchYear)
                .build();

    }

    //TEMPORARIO
    public Personagem TrazerPersonagem(int id) {
        return personagensRepository.findById(id)
                .orElseThrow(()-> new NonExistentID(id));
    }
}


