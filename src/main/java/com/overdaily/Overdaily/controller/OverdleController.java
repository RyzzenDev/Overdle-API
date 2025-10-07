package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.Service.OverdleService;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Overdle")
public class OverdleController {

    @Autowired
    private OverdleService overdleService;

    @GetMapping("/personagem")
    public Optional<Personagem> RandomPersonagem(){

        return overdleService.PersonagemOFTD();
    }
}
