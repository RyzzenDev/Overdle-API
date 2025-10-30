package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Hero;

public record ListHeroesDTO (
        Integer id,
        String heroName,
        String heroRole

){
    public ListHeroesDTO (Hero hero){

        this(   hero.getId(),
                hero.getHeroName(),
                hero.getHeroRole()
        );
    }
}
