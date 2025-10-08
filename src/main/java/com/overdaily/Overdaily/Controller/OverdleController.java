package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.model.*;
import com.overdaily.Overdaily.Service.OverdleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/Overdle")
public class OverdleController {

    private final OverdleService overdleService;

    public OverdleController(OverdleService overdleService) {
        this.overdleService = overdleService;
    }

    @GetMapping("/Randomize/Hero")
    public Optional<Personagem> RandomPersonagem(){

        return overdleService.PersonagemOFTD();
    }
    @GetMapping("/Randomize/Gun")
    public Optional<Arma> RandomGun(){

        return overdleService.ArmaOFTD();
    }

    @GetMapping("/Randomize/Ability")
    public Optional<Habilidade> RandomAbility() {
        return overdleService.HabilidadeOFTD();
    }

    @GetMapping("/Randomize/Voice")
    public Optional<Fala> RandomVoice() {
        return overdleService.FalaOFTD();
    }

    @GetMapping("/Randomize/Map")
    public Optional<Mapa> RandomMap() {
        return overdleService.MapaOFTD();
    }

    @GetMapping("/Secret/Hero")
    public Optional<Personagem> TrazerPersonagem(){

        return overdleService.TrazerPersonagem();

    }
    @GetMapping("/Secret/Gun")
    public Optional<Arma> TrazerArma(){

        return overdleService.TrazerArma();
    }

    @GetMapping("/Secret/Ability")
    public Optional<Habilidade> TrazerAbility() {
        return overdleService.TrazerHabilidade();
    }

    @GetMapping("/Secret/Voice")
    public Optional<Fala> TrazerVoice() {
        return overdleService.TrazerFala();
    }

    @GetMapping("/Secret/Map")
    public Optional<Mapa> TrazerMap() {
        return overdleService.TrazerMapa();
    }

    /*
    @PostMapping("/Guess/Age/{HeroGuess}")
    public String GuessIdade(@PathVariable int HeroGuess){

        return overdleService.CheckIdade(HeroGuess);
    }

     */

}
