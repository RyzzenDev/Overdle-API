package com.overdaily.dto;

import com.overdaily.entity.Hero;
import lombok.Builder;

@Builder
public record HeroDTO(
        Integer id,
        String photo,
        String affiliation,
        String role,
        String name,
        String realName,
        Integer health,
        Integer age,
        String gender,
        String country,
        String firstComposition,
        String secondComposition,
        Integer launchYear
) {

    public HeroDTO(Hero hero) {
        this(
                hero.getId(),
                hero.getHeroPhoto(),       // photo
                hero.getHeroAffiliation(), // affiliation
                hero.getHeroRole(),        // role
                hero.getHeroName(),        // name
                hero.getHeroRealName(),    // realName
                hero.getHeroHealth(),      // health
                hero.getHeroAge(),         // age
                hero.getHeroGender(),      // gender
                hero.getHeroCountry(),     // country
                hero.getHeroComp(),        // firstComposition
                hero.getHeroComp2(),       // secondComposition
                hero.getHeroYear()         // launchYear
        );
    }
}
