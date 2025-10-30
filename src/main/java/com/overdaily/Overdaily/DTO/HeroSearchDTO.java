package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Hero;

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
          String Composition2,
          Integer LaunchYear
                ) {

    public HeroSearchDTO(Hero hero) {
        this (
                hero.getHeroAffiliation(),
                hero.getHeroRole(),
                hero.getHeroName(),
                hero.getHeroRealName(),
                hero.getHeroPhoto(),
                hero.getHeroHealth(),
                hero.getHeroAge(),
                hero.getHeroGender(),
                hero.getHeroCountry(),
                hero.getHeroComp(),
                hero.getHeroComp2(),
                hero.getHeroYear()
        );
    }
}
