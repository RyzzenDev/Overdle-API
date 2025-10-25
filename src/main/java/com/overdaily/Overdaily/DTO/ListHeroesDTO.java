package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Personagem;

public record ListHeroesDTO (
        Integer id,
        String nomeAgente,
        String tipoAgente

){
    public ListHeroesDTO (Personagem personagem){

        this(   personagem.getId(),
                personagem.getNomeAgente(),
                personagem.getTipoAgente()
        );
    }
}
