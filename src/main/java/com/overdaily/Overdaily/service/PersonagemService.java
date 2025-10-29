package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.exceptions.Personagem.NonExistentID;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PersonagemService {


    private final PersonagemRepository personagensRepository;
    private final Personagem personagemDoDia;
    private final RedisTemplate<String, Object> redisTemplate;

    public PersonagemService(PersonagemRepository personagensRepository, RedisTemplate<String, Object> redisTemplate) {
        this.personagensRepository = personagensRepository;
        this.personagemDoDia = new Personagem();
        this.redisTemplate = redisTemplate;
    }

    HashMap<Integer, String> SelectedHero = new HashMap<>();

    int id;

    public HeroSearchDTO SearchID(Integer id) {
        Personagem personagembuscado = personagensRepository.findById(id)
                .orElseThrow(() -> new NonExistentID(id));
        return new HeroSearchDTO(personagembuscado);
    }

    public List<ListHeroesDTO> IDList() {
        List<Personagem> HeroList = personagensRepository.findAll();
        return HeroList.stream()
                .map(ListHeroesDTO::new)
                .toList();
    }

    public List<ListHeroesDTO> SearchRole(String heroType) {
        List<Personagem> HeroList = personagensRepository.findAll();

        List<ListHeroesDTO> ListaBuscada = new java.util.ArrayList<>();

        String heroRole = heroType.toLowerCase();


        switch (heroRole) {
            case "tank": {
                List<ListHeroesDTO> RoleTankList = HeroList.stream()
                        .filter(personagem -> "Tank".equals(personagem.getTipoAgente()))
                        .map(ListHeroesDTO::new)
                        .toList();
                ListaBuscada = RoleTankList;

                return ListaBuscada;

            }
            case "damage": {
                List<ListHeroesDTO> RoleDamageList = HeroList.stream()
                        .filter(personagem -> "Damage".equals(personagem.getTipoAgente()))
                        .map(ListHeroesDTO::new)
                        .toList();
                ListaBuscada = RoleDamageList;

                return ListaBuscada;

            }
            case "support": {
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

    public Personagem TrazerPersonagem(int id) {
        return personagensRepository.findById(id)
                .orElseThrow(() -> new NonExistentID(id));
    }

    public String RandomizeID() {
        Random NumeroRandom = new Random();
        id = NumeroRandom.nextInt(44);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);

        return " Hero Selected at: " + timeFormatted;
    }

    public ServerGuessResponseDTO checkTotal(int guessedHero) {
        Map<Object, Object>HeroOFTD = redisTemplate.opsForHash().entries("hero"+id);
        Map<Object, Object>guessedHeroOFTD = redisTemplate.opsForHash().entries("hero"+guessedHero);

        String checkName = checkName(HeroOFTD, guessedHeroOFTD);
        String checkGender = checkGender(HeroOFTD, guessedHeroOFTD);
        String checkHealth = checkHealth(HeroOFTD, guessedHeroOFTD);
        String checkAge = checkAge(HeroOFTD, guessedHeroOFTD);
        String checkRole = checkRole(HeroOFTD,guessedHeroOFTD);
        String checkAffiliation = checkAffiliation(HeroOFTD, guessedHeroOFTD);
        String checkComposition = checkComposition(HeroOFTD, guessedHeroOFTD);
        String checkSecondComposition = checkSecondComposition(HeroOFTD, guessedHeroOFTD);
        String checkLaunchYear = checkLaunchYear(HeroOFTD, guessedHeroOFTD);


        return ServerGuessResponseDTO.builder()
                .Name(checkName)
                .Gender(checkGender)
                .Health(checkHealth)
                .Role(checkRole)
                .Age(checkAge)
                .Affiliation(checkAffiliation)
                .Composition(checkComposition)
                .Composition2(checkSecondComposition)
                .LaunchYear(checkLaunchYear)
                .build();
    }

    public String checkName(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD ) {
        String check;
        String correctName = (String) HeroOFTD.get("nomeAgente");
        String guessedName = (String) guessedHeroOFTD.get("nomeAgente");

        if (guessedName.equals(correctName)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkGender(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctGender = (String) HeroOFTD.get("generoAgente");
        String guessedGender = (String) guessedHeroOFTD.get("generoAgente");

        if (guessedGender.equals(correctGender))

        {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkHealth(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        Integer correctHealth = (Integer) HeroOFTD.get("vidaAgente");
        Integer guessedHealth = (Integer) guessedHeroOFTD.get("vidaAgente");

        if (guessedHealth.equals(correctHealth)) {
            check = "Correct";
        } else if (guessedHealth < correctHealth) {
            check = "More";
        } else {
            check = "Less";
        }
        return check;

    }

    public String checkAge(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String Check;
        Integer correctAge = (Integer) HeroOFTD.get("idadeAgente");
        Integer guessedAge = (Integer) guessedHeroOFTD.get("idadeAgente");

        if (correctAge.equals(guessedAge)) {
            Check = "Correct";
        } else if (guessedAge < correctAge) {
            Check = "Older";
        } else {
            Check = "Younger";
        }
        return Check;
    }

    public String checkRole(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctRole = (String) HeroOFTD.get("tipoAgente");
        String guessedRole = (String) guessedHeroOFTD.get("tipoAgente");

        if (guessedRole.equals(correctRole)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;
    }

    public String checkAffiliation(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String Check;
        String correctAffiliation = (String) HeroOFTD.get("afiliacaoAgente");
        String guessedAffiliation = (String) guessedHeroOFTD.get("afiliacaoAgente");

        if (guessedAffiliation.equals(correctAffiliation)) {
            Check = "Correct";
        } else {
            Check = "Wrong";
        }
        return Check;

    }

    public String checkComposition(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctComposition = (String) HeroOFTD.get("compAgente");
        String guessedComposition = (String) guessedHeroOFTD.get("compAgente");

        if (guessedComposition.equals(correctComposition)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }

        return check;
    }

    public String checkSecondComposition(Map<Object, Object > HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctComposition = (String) HeroOFTD.get("compAgente2");
        String guessedComposition = (String) guessedHeroOFTD.get("compAgente2");

        if (guessedComposition.equals(correctComposition)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }

        return check;
    }

    public String checkLaunchYear(Map<Object, Object>HeroOFTD, Map<Object, Object>guessedHeroOFTD) {
        String check;
        Integer correctYear = (Integer) HeroOFTD.get("anoAgente");
        Integer guessedYear = (Integer) guessedHeroOFTD.get("anoAgente");

        if (guessedYear.equals(correctYear)) {
            check = "Correct";
        } else if (correctYear > guessedYear) {
            check = "Later";

        } else
            check = "Earlier";

        return check;
    }

}
