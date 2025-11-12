package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.entity.Hero;
import lombok.Builder;

@Builder
public record HeroSearchDTO(
          String Photo,
          String Affiliation,
          String Role,
          String Name,
          String RealName,
          Integer Health,
          Integer Age,
          String Gender,
          String Country,
          String FirstComposition,
          String SecondComposition,
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
