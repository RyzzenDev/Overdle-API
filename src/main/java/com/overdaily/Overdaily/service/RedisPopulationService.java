package com.overdaily.Overdaily.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.overdaily.Overdaily.Repository.PersonagemRepository;
import com.overdaily.Overdaily.model.Personagem;
import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisPopulationService {

    private final PersonagemRepository personagemRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisPopulationService(PersonagemRepository personagemRepository, RedisTemplate redisTemplate) {
        this.personagemRepository = personagemRepository;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void SQLtoRedis() {
        System.out.println("Puxando Dados");

        ObjectMapper objectMapper = new ObjectMapper();

        for (Personagem personagem : personagemRepository.findAllWithDetails()) {
            String key = "hero" + personagem.getId();

            Map<String, Object> personagemMap = objectMapper.convertValue(personagem, Map.class);

            redisTemplate.opsForHash().putAll(key, personagemMap);
        }
        System.out.println("Dados Atualizados com sucesso " +personagemRepository.count()+ " Personagens");

    }

}
