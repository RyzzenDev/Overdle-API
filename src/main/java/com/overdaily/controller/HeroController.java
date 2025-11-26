package com.overdaily.controller;


import com.overdaily.dto.HeroDTO;
import com.overdaily.entity.Hero;
import com.overdaily.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(
        origins = "https://overdle.vercel.app",
        methods = {RequestMethod.GET, RequestMethod.POST}
)
@RequestMapping("/heroes")

public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<HeroDTO>> getAll() {
        return ResponseEntity.ok().body(heroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getByID(@PathVariable Integer id) {
        System.out.println("tenttando pegar id: " + id);
        System.out.println("retornei: " + heroService.getByID(id));
        return ResponseEntity.ok().body(heroService.getByID(id));
    }

    //isso n pode existir deixei só p ambiente de dev,
    @GetMapping("/randomize")
    public void randomizer() {
        heroService.randomizeID();
    }

    @PostMapping("/guess/{guessedHero}")
    public ResponseEntity<String> checkGuess(@PathVariable Hero guessedHero) {
        return ResponseEntity.ok().build();
    }
}
//
//    @GetMapping("/Date")
//    public ResponseEntity<OffsetDateTime> Date() {
//        return ResponseEntity.ok(heroService.Date());
//    }
//
//    @GetMapping("/GameCount")
//    public ResponseEntity<Integer> getGameCount() {
//        return ResponseEntity.ok(heroService.GameCount());
//    }
//}