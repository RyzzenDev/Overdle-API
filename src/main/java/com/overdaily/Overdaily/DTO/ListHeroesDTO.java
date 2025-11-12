package com.overdaily.Overdaily.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListHeroesDTO{
        Integer id;
        String heroName;
        String heroPortrait;
}
