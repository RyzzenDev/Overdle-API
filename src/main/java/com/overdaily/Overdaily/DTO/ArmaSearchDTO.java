package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Arma;

public record ArmaSearchDTO(
        String personagemArma,
        String imagemArma,
        String tipoTiro,
        String tipoArma,
        Integer danoArma,
        String headshot,
        Integer municao,
        String somArma

){
    public ArmaSearchDTO(Arma arma){
        this(
        arma.getPersonagemArma(),
        arma.getImagemArma(),
        arma.getTipoTiro(),
        arma.getTipoArma(),
        arma.getDanoArma(),
        arma.getHeadshot(),
        arma.getMunicao(),
        arma.getSomArma()
        );
    }
}
