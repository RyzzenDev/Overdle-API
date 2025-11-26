package com.overdaily.service;

import com.overdaily.Repository.HeroRepository;
import com.overdaily.dto.HeroDTO;
import com.overdaily.entity.Hero;
import com.overdaily.exceptions.Hero.HeroNotFoundException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HeroService {

    private final HeroRepository heroRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    @Getter
    private final List<Hero> heroList = new ArrayList<>();
    private int id;
    private OffsetDateTime date;
    private int gameCount = 0;
    private Random random = new Random();

    @Autowired
    public HeroService(HeroRepository heroRepository, RedisTemplate<String, Object> redisTemplate) {
        this.heroRepository = heroRepository;
        this.redisTemplate = redisTemplate;

    }

    @PostConstruct
    public void loadAll() {
        heroList.clear();
        heroList.addAll(heroRepository.findAll());
        System.out.println("Cached all heroes.");
    }

    public List<HeroDTO> getAll() {
        return heroList.stream()
                .map(HeroDTO::new)
                .toList();
    }

    public HeroDTO getByID(Integer id) {
        HeroDTO cachedHero = heroList.stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .map(HeroDTO::new)
                .orElse(null);

        if (cachedHero != null) return cachedHero;

        return heroRepository.findById(id)
                .map(HeroDTO::new)
                .orElseThrow(() -> new HeroNotFoundException("Hero with id " + id + " doesn't exist."));
    }

    public Hero getDayHero() {
        return null;
    }

    public String checkGuess(Hero guessHero) {
        return null;
    }

    @Scheduled(fixedRate = 86400000)
    public void randomizeID() {


        id = this.random.nextInt(44);
        redisTemplate.opsForValue().set("hero-of-day", getByID(id));
        System.out.println("Randomized hero ID: " + id);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        date = OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS);
        gameCount++;

    }
}