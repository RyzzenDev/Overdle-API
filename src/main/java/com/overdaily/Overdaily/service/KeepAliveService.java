package com.overdaily.Overdaily.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class KeepAliveService {
    private static final String PING_ENDPOINT = "/Heroes/Date";
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${backend.base-url}")
    private String baseUrl;

    @Scheduled(fixedRate = 840000)
    public void selfPing() {
        try {
            String url = baseUrl + PING_ENDPOINT;
            restTemplate.getForObject(url, String.class);
            System.out.println("Ping de Keep-Alive executado com sucesso em: " + java.time.LocalDateTime.now());
        } catch (Exception e) {
            System.err.println("Falha no self-ping de Keep-Alive: " + e.getMessage());
        }
    }
}
