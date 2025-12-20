package com.overdaily.Overdaily.Controller;

import com.overdaily.Overdaily.service.serverServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

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
/*
    @GetMapping("/DB")
    public ResponseEntity<Integer> DB(){
        return ResponseEntity.ok(serverServices.teste());
    }

 */
}

