package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.service.OverdleService;
import com.overdaily.Overdaily.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/Overdle")
public class OverdleController {


    private OverdleService overdleService;

    public OverdleController(OverdleService overdleService) {
        this.overdleService = overdleService;
    }


    @GetMapping("/personagem")
    public Optional<Personagem> RandomPersonagem(){

        return overdleService.PersonagemOFTD();
    }
}
