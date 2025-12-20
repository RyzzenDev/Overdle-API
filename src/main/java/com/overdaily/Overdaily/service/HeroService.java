package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.HeroRepository;
import com.overdaily.Overdaily.entity.Server;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Service
public class HeroService {
    private final serverServices serverServices;
    private final HeroRepository heroRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public HeroService(HeroRepository heroRepository, RedisTemplate<String, Object> redisTemplate, serverServices serverServices) {
        this.heroRepository = heroRepository;
        this.redisTemplate = redisTemplate;
        this.serverServices = serverServices;
    }

    int id;
    OffsetDateTime date;
    int gameCount = 0;

    public List<ListHeroesDTO> ListByRole(String role) {
        int i = 1;
        List<ListHeroesDTO> listHeroes = new ArrayList<>();
        int DBSize = (int) heroRepository.count();
        String FormattedRole = role.substring(0, 1).toUpperCase() + role.substring(1).toLowerCase();
        do {

            Map<Object, Object> HeroDB = redisTemplate.opsForHash().entries("hero" + i);

            if (HeroDB.get("heroRole").equals(FormattedRole)) {

                ListHeroesDTO listRole = ListHeroesDTO.builder()
                        .id((int) HeroDB.get("id"))
                        .heroName((String) HeroDB.get("heroName"))
                        .build();

                listHeroes.add(listRole);
                i++;

            } else {
                i++;
            }

        } while (i < DBSize);
        return listHeroes;
    }

    public List<ListHeroesDTO> ListDB() {
        int i = 1;

        List<ListHeroesDTO> list = new ArrayList<>();
        int DBSize = (int) heroRepository.count();
        do {
            Map<Object, Object> HeroDB = redisTemplate.opsForHash().entries("hero" + i);
            ListHeroesDTO buildhero = ListHeroesDTO.builder()
                    .id((int) HeroDB.get("id"))
                    .heroName((String) HeroDB.get("heroName"))
                    .heroPortrait((String) HeroDB.get("heroPortrait"))
                    .build();
            list.add(buildhero);
            i++;
        } while (i <= DBSize);
        return list;

    }

    public HeroSearchDTO SearchID(Integer id) {

        Map<Object, Object> SearchedHero = redisTemplate.opsForHash().entries("hero" + id);

        if (SearchedHero.isEmpty()) {
            throw new com.overdaily.Overdaily.exceptions.ResourceNotFoundException("Hero not found with id: " + id);
        }

        return HeroSearchDTO.builder()
                .Photo((String) SearchedHero.get("heroPhoto"))
                .Affiliation((String) SearchedHero.get("heroAffiliation"))
                .Role((String) SearchedHero.get("heroRole"))
                .Name((String) SearchedHero.get("heroName"))
                .RealName((String) SearchedHero.get("heroRealName"))
                .Age((Integer) SearchedHero.get("heroAge"))
                .Health((Integer) SearchedHero.get("heroHealth"))
                .Gender((String) SearchedHero.get("heroGender"))
                .Country((String) SearchedHero.get("heroCountry"))
                .FirstComposition((String) SearchedHero.get("heroComp"))
                .SecondComposition((String) SearchedHero.get("HeroComp2"))
                .LaunchYear((Integer) SearchedHero.get("heroYear"))
                .build();
    }

    @Scheduled(cron = "0 0 0 * * ?", zone = "UTC")
    @EventListener(ApplicationReadyEvent.class)
    public String RandomizeID() {
        int count = (int) heroRepository.count()+1;
        System.out.println("Randomizing Hero");
        Random NumeroRandom = new Random();
        id = NumeroRandom.nextInt(count);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        date = OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS);
        gameCount++;
        return " Hero Selected at: " + timeFormatted;
    }

    public OffsetDateTime Date() {
        return date;
    }

    public int GameCount() {
        return gameCount;
    }

    public ServerGuessResponseDTO guessCheck(int guessedHero) {
        Map<Object, Object> HeroOFTD = redisTemplate.opsForHash().entries("hero" + id);
        Map<Object, Object> guessedHeroOFTD = redisTemplate.opsForHash().entries("hero" + guessedHero);

        String checkName = checkName(HeroOFTD, guessedHeroOFTD);
        String checkGender = checkGender(HeroOFTD, guessedHeroOFTD);
        String checkHealth = checkHealth(HeroOFTD, guessedHeroOFTD);
        String checkAge = checkAge(HeroOFTD, guessedHeroOFTD);
        String checkRole = checkRole(HeroOFTD, guessedHeroOFTD);
        String checkAffiliation = checkAffiliation(HeroOFTD, guessedHeroOFTD);
        String checkComposition = checkComposition(HeroOFTD, guessedHeroOFTD);
        String checkSecondComposition = checkSecondComposition(HeroOFTD, guessedHeroOFTD);
        String checkLaunchYear = checkLaunchYear(HeroOFTD, guessedHeroOFTD);

        return ServerGuessResponseDTO.builder()
                .id((Integer) guessedHeroOFTD.get("id"))
                .heroPortrait((String) guessedHeroOFTD.get("heroPortrait"))
                .guessedHeroPortrait((String) guessedHeroOFTD.get("heroPortrait"))
                .Name(checkName)
                .Gender(checkGender)
                .Health(checkHealth)
                .Role(checkRole)
                .Age(checkAge)
                .Affiliation(checkAffiliation)
                .Composition(checkComposition)
                .Composition2(checkSecondComposition)
                .LaunchYear(checkLaunchYear)
                .guessedName((String) guessedHeroOFTD.get("heroName"))
                .guessedGender((String) guessedHeroOFTD.get("heroGender"))
                .guessedHealth((Integer) guessedHeroOFTD.get("heroHealth"))
                .guessedRole((String) guessedHeroOFTD.get("heroRole"))
                .guessedAge((Integer) guessedHeroOFTD.get("heroAge"))
                .guessedAffiliation((String) guessedHeroOFTD.get("heroAffiliation"))
                .guessedComposition((String) guessedHeroOFTD.get("heroComp"))
                .guessedComposition2((String) guessedHeroOFTD.get("heroComp2"))
                .guessedLaunchYear((Integer) guessedHeroOFTD.get("heroYear"))
                .build();
    }

    public String checkName(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctName = (String) HeroOFTD.get("heroName");
        String guessedName = (String) guessedHeroOFTD.get("heroName");

        if (guessedName.equals(correctName)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkGender(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctGender = (String) HeroOFTD.get("heroGender");
        String guessedGender = (String) guessedHeroOFTD.get("heroGender");

        if (guessedGender.equals(correctGender))

        {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;

    }

    public String checkHealth(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        Integer correctHealth = (Integer) HeroOFTD.get("heroHealth");
        Integer guessedHealth = (Integer) guessedHeroOFTD.get("heroHealth");

        if (Objects.equals(guessedHealth, correctHealth)) {
            check = "Correct";
        } else if (guessedHealth < correctHealth) {
            check = "More";
        } else {
            check = "Less";
        }
        return check;

    }

    public String checkAge(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String Check;
        Integer correctAge = (Integer) HeroOFTD.get("heroAge");
        Integer guessedAge = (Integer) guessedHeroOFTD.get("heroAge");

        if (correctAge.equals(guessedAge)) {
            Check = "Correct";
        } else if (guessedAge < correctAge) {
            Check = "Older";
        } else {
            Check = "Younger";
        }
        return Check;
    }

    public String checkRole(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctRole = (String) HeroOFTD.get("heroRole");
        String guessedRole = (String) guessedHeroOFTD.get("heroRole");

        if (guessedRole.equals(correctRole)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }
        return check;
    }

    public String checkAffiliation(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String Check;
        String correctAffiliation = (String) HeroOFTD.get("heroAffiliation");
        String guessedAffiliation = (String) guessedHeroOFTD.get("heroAffiliation");

        if (guessedAffiliation.equals(correctAffiliation)) {
            Check = "Correct";
        } else {
            Check = "Wrong";
        }
        return Check;

    }

    public String checkComposition(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctComposition = (String) HeroOFTD.get("heroComp");
        String guessedComposition = (String) guessedHeroOFTD.get("heroComp");

        if (guessedComposition.equals(correctComposition)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }

        return check;
    }

    public String checkSecondComposition(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        String correctComposition = (String) HeroOFTD.get("heroComp2");
        String guessedComposition = (String) guessedHeroOFTD.get("heroComp2");

        if (guessedComposition.equals(correctComposition)) {
            check = "Correct";
        } else {
            check = "Wrong";
        }

        return check;
    }

    public String checkLaunchYear(Map<Object, Object> HeroOFTD, Map<Object, Object> guessedHeroOFTD) {
        String check;
        Integer correctYear = (Integer) HeroOFTD.get("heroYear");
        Integer guessedYear = (Integer) guessedHeroOFTD.get("heroYear");

        if (guessedYear.equals(correctYear)) {
            check = "Correct";
        } else if (correctYear > guessedYear) {
            check = "Later";

        } else
            check = "Earlier";

        return check;
    }

}
