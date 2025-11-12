package com.overdaily.Overdaily.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.overdaily.Overdaily.Repository.HeroRepository;
import com.overdaily.Overdaily.entity.Hero;
import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisPopulationService {

    private final HeroRepository heroRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisPopulationService(HeroRepository heroRepository, RedisTemplate redisTemplate) {
        this.heroRepository = heroRepository;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void SQLtoRedis() {
        System.out.println("Updating Hero Data");

        ObjectMapper objectMapper = new ObjectMapper();

        for (Hero hero : heroRepository.findAllWithDetails()) {
            String key = "hero" + hero.getId();

            Map<String, Object> personagemMap = objectMapper.convertValue(hero, Map.class);

            redisTemplate.opsForHash().putAll(key, personagemMap);
        }
        System.out.println("Hero data up to date with a total of  -> " + heroRepository.count()+ " Unique Heroes ");

    }

}
