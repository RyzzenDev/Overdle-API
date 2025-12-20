package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.Repository.HeroRepository;
import com.overdaily.Overdaily.Repository.ServerRepository;
import com.overdaily.Overdaily.entity.Server;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
public class serverServices {
    private final HeroRepository heroRepository;
    private final ServerRepository serverRepository;

    public serverServices(HeroRepository heroRepository, ServerRepository serverRepository) {
        this.heroRepository = heroRepository;
        this.serverRepository = serverRepository;
    }

    int[] id;
    OffsetDateTime date;
    List<Server> test;

    public String RandomizeID() {

        Server server = new Server();
        System.out.println("Randomizing Heroes");

        Random random = new Random();
        for (int i = 0; i <= 5; i++) {

            int heroes = (int) heroRepository.count();

            server.setHero(random.nextInt(heroes)+1);
            server.setAbility(random.nextInt(heroes)+1);
            server.setGun(random.nextInt(heroes)+1);
            server.setVoiceline(random.nextInt(heroes)+1);
            server.setUltimate(random.nextInt(heroes)+1);
            server.setMaps(0);

        }
        OffsetDateTime date = OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS);
        server.setTimestamp(date);
        serverRepository.save(server);
        return " Hero Selected at: " + date +" TESTE SERVER " +server;
    }
}
