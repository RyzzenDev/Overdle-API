package com.overdaily.Overdaily.controller;

import com.overdaily.Overdaily.model.Armas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/armas")
public class ArmasController {

    @Autowired
    private ArmasService armasService;

    @GetMapping()
    public List<Armas> pegarTodos() {
        return armasService.findAll();
    }

}
