package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Personagem;

public record PersonagemSearchDTO(

          String nomeAgente,
          String nomeRealAgente,
          String fotoAgente,
          Integer vidaAgente,
          Short idadeAgente,
          String sexoAgente,
          String paisAgente,
          String tipoAgente
                ) {

    public PersonagemSearchDTO (Personagem personagem) {
        this (
                personagem.getNomeAgente(),
                personagem.getNomeRealAgente(),
                personagem.getFotoAgente(),
                personagem.getVidaAgente(),
                personagem.getIdadeAgente(),
                personagem.getSexoAgente(),
                personagem.getPaisAgente(),
                personagem.getTipoAgente()
        );
    }
}
