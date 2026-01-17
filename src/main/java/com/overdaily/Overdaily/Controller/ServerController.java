package com.overdaily.Overdaily.Controller;

import com.overdaily.Overdaily.entity.Hero;
import com.overdaily.Overdaily.service.serverServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(
        origins = {"https://www.overdle.com", "https://overdle.com"},
        methods = { RequestMethod.GET, RequestMethod.POST }
)

@RequestMapping("/Service")
public class ServerController {

    private final serverServices serverServices;
    public ServerController(serverServices serverServices) {
        this.serverServices = serverServices;
    }

    @GetMapping("/Randomize")
    public ResponseEntity<String> Randomize(){
        return ResponseEntity.ok(serverServices.RandomizeID());
    }

    @GetMapping("/Count")
    public ResponseEntity<Integer> HeroCount(){
        return ResponseEntity.ok(serverServices.herocount());
    }
/*
    @GetMapping("/DB")
    public ResponseEntity<Integer> DB(){
        return ResponseEntity.ok(serverServices.teste());
    }

 */
}

