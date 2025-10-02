package com.overdaily.Overdaily.controller;


import com.overdaily.Overdaily.model.Personagens;
import com.overdaily.Overdaily.service.PersonagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagens")

public class PersonagensController {

    @GetMapping()
    public List<Personagens> pegarTodos() {
        return personagensService.pegarTodos();
    }






    /*Aqui todos os metódos criados após essa linha que conter uma
     Exemplo:


     sempre que tiver um metodo com / no começo vai ser sempre com /personagens no começo, exemplo:

        @GetMapping("/teste")
        public teste metodoTeste() {
        }
        esse metodo tá pegando o GET do /personagens/teste


        @GetMapping("/salve")
        public teste metodoTeste2() {
        }
        esse metodo tá pegando o GET do /personagens/salve


     */


    @Autowired
    private PersonagensService personagensService;


    @GetMapping("/{id}")
    public Optional<Personagens> getPersonagem(@PathVariable Short id) {

        System.out.println("Buscando o id: " + id);
        return personagensService.findById(id);
    }

    @GetMapping("/tipoAgente/{id}")
    public List<Personagens> getPersonagemTipo(@PathVariable String tipoAgente) {
        return personagensService.getPersonagensByTipoAgente(tipoAgente);
    }

    /*
    @GetMapping("/{personagemArma")
    public Optional<Arma> getPersonagemArma(@PathVariable String personagemArma) {
        if(personagemArma.contains("adagas")) {
         return ColorEnum.RED;
        }
        if(personagemArma.contains("espadas")) {
            return ColorEnum.GREEN;
            }
        }
        return personagemRepository.findByArma(personagemArma).orElseThrow(
    }
     */

}
