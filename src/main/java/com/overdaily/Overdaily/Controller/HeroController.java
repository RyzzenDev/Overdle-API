package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Heroes")

public class HeroController {


    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/IDList")
    public List<ListHeroesDTO> IDList() {
        return heroService.IDList();
    }

    @GetMapping("/Search/{id}")
    public HeroSearchDTO SearchID(@PathVariable Integer id) {
        return heroService.SearchID(id);
    }
    /*
    @GetMapping("/ListRole/{heroRole}")
    public List<ListHeroesDTO> SearchRole(@PathVariable String heroRole) {
        return heroService.SearchRole(heroRole);
    }
     */

    @GetMapping("/Randomize")
    public String Randomizer(){
        return heroService.RandomizeID();
    }
    @PostMapping("/Guess/{guessedHero}")
    public ServerGuessResponseDTO GuessCheck(@PathVariable int guessedHero){
        return heroService.guessCheck(guessedHero);
    }
}
