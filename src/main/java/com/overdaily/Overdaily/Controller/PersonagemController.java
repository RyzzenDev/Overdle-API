package com.overdaily.Overdaily.Controller;


import com.overdaily.Overdaily.model.Personagem;
import com.overdaily.Overdaily.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagens")

public class PersonagemController {

    @GetMapping()
    public List<Personagem> pegarTodos() {
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
    private PersonagemService personagensService;


    @GetMapping("/{id}")
    public Optional<Personagem> getPersonagem(@PathVariable Integer id) {

        System.out.println("Buscando o id: " + id);
        return personagensService.findById(id);
    }

    @GetMapping("/tipoAgente/{id}")
    public List<Personagem> getPersonagemTipo(@PathVariable String tipoAgente) {
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
