package com.overdaily.Overdaily.service;

import com.overdaily.Overdaily.Repository.*;
import com.overdaily.Overdaily.model.*;
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

    List<Integer> Daily = new ArrayList<>();

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
        int id = NumeroRandom.nextInt(3);
        personagemDoDia.setId(id);
        Daily.add(0, id);
        return personagemRepository.findById(personagemDoDia.getId());
    }

    public Optional<Arma> ArmaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        armaDoDia.setId(id);
        Daily.add(1, id);
        return armaRepository.findById(armaDoDia.getId());
    }

    public Optional<Habilidade> HabilidadeOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        habilidadeDoDia.setId(id);
        Daily.add(2, id);
        return habilidadeRepository.findById(habilidadeDoDia.getId());
    }

    public Optional<Fala> FalaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        falaDoDia.setId(id);
        Daily.add(3, id);
        return falaRepository.findById(falaDoDia.getId());
    }

    public Optional<Mapa> MapaOFTD() {
        Random NumeroRandom = new Random();
        int id = NumeroRandom.nextInt(3);
        mapaDoDia.setId(id);
        Daily.add(id);
        return mapaRepository.findById(mapaDoDia.getId());
    }

    public Optional<Personagem> TrazerPersonagem() {
        return personagemRepository.findById(Daily.get(0));
    }

    public Optional<Arma> TrazerArma() {
        return armaRepository.findById(Daily.get(1));

    }
    public Optional<Habilidade> TrazerHabilidade() {
        return habilidadeRepository.findById(Daily.get(2));
    }

    public Optional<Fala> TrazerFala() {
        return falaRepository.findById(Daily.get(3));
    }

    public Optional<Mapa> TrazerMapa() {
        return mapaRepository.findById(Daily.get(4));
    }

}
