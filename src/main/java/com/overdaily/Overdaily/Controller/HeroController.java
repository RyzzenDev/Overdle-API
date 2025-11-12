package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.HeroRepository;
import com.overdaily.Overdaily.entity.Hero;
import com.overdaily.Overdaily.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin(
        origins = "http://localhost:8081", // A porta do seu front-end
        methods = { RequestMethod.GET, RequestMethod.POST } // <-- ADICIONE ISSO
)
@RequestMapping("/Heroes")

public class HeroController {

    private final HeroService heroService;
    private final HeroRepository heroRepository;

    public HeroController(HeroService heroService, HeroRepository heroRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
    }
    @GetMapping("/Search/{id}")
    public ResponseEntity<HeroSearchDTO> SearchID(@PathVariable Integer id) {
        return ResponseEntity.ok(heroService.SearchID(id));
    }
    @GetMapping("/SearchRole/{role}")
    public ResponseEntity<List<ListHeroesDTO>> ListRole(@PathVariable String role) {
        return ResponseEntity.ok(heroService.ListByRole(role));
    }
    @GetMapping("/ListDB")
    public ResponseEntity<List<ListHeroesDTO>> ListDB(){
        return ResponseEntity.ok(heroService.ListDB());
    }
    @GetMapping("/Randomize")
    public ResponseEntity<String> Randomizer(){
        return ResponseEntity.ok(heroService.RandomizeID());
    }
    @PostMapping("/Guess/{guessedHero}")
    public ResponseEntity<ServerGuessResponseDTO> GuessCheck(@PathVariable int guessedHero){
        return ResponseEntity.ok(heroService.guessCheck(guessedHero));
    }
}
