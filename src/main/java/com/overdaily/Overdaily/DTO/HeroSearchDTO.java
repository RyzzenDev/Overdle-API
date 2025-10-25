package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Personagem;

public record HeroSearchDTO(
          String Affiliation,
          String Role,
          String Name,
          String RealName,
          String Photo,
          Integer Health,
          Short Age,
          String Gender,
          String Country,
          String Composition,
          Integer LaunchYear
                ) {

    public HeroSearchDTO(Personagem personagem) {
        this (
                personagem.getAfiliacaoAgente(),
                personagem.getTipoAgente(),
                personagem.getNomeAgente(),
                personagem.getNomeRealAgente(),
                personagem.getFotoAgente(),
                personagem.getVidaAgente(),
                personagem.getIdadeAgente(),
                personagem.getGeneroAgente(),
                personagem.getPaisAgente(),
                personagem.getCompAgente(),
                personagem.getAnoAgente()
        );
    }
}
