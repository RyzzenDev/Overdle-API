package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.DTO.HeroSearchDTO;
import com.overdaily.Overdaily.DTO.ListHeroesDTO;
import com.overdaily.Overdaily.DTO.ServerGuessResponseDTO;
import com.overdaily.Overdaily.Repository.HeroRepository;
import com.overdaily.Overdaily.service.HeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;


@RestController
@CrossOrigin(
        origins = "https://www.overdle.com",
        methods = { RequestMethod.GET, RequestMethod.POST }
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
    public ResponseEntity<String> RandomizeID() {
        return ResponseEntity.ok(heroService.RandomizeID());
    }
    @PostMapping("/Guess/{guessedHero}")
    public ResponseEntity<ServerGuessResponseDTO> GuessCheck(@PathVariable int guessedHero){
        return ResponseEntity.ok(heroService.guessCheck(guessedHero));
    }
    @GetMapping("/Date")
    public ResponseEntity<OffsetDateTime> Date(){
        return  ResponseEntity.ok(heroService.Date());
    }
    @GetMapping("/GameCount")
    public ResponseEntity<Integer> getGameCount(){
        return ResponseEntity.ok(heroService.GameCount());
    }
    }