package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.model.Personagem;
import com.overdaily.Overdaily.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Heroes")

public class PersonagemController {

    @Autowired
    private PersonagemService personagensService;

    @GetMapping("/IDList")
    public List<ListHeroesDTO> IDList() {
        return personagensService.IDList();
    }

    @GetMapping("/Search/{id}")
    public HeroSearchDTO SearchID(@PathVariable Integer id) {
        return personagensService.SearchID(id);
    }

    @GetMapping("/ListRole/{heroRole}")
    public List<ListHeroesDTO> SearchRole(@PathVariable String heroRole) {
        return personagensService.SearchRole(heroRole);
    }

    @GetMapping("/Randomize")
    public String Teste(){
        return personagensService.RandomizeID();
    }
    @PostMapping("/Guess/{guessedHero}")
    public ServerGuessResponseDTO checkTotal(@PathVariable int guessedHero){
        return personagensService.checkTotal(guessedHero);
    }

    @GetMapping("/Trazer/{id}")
    public Personagem TrazerPersonagem(@PathVariable int id){
        return personagensService.TrazerPersonagem(id);
    }

}
