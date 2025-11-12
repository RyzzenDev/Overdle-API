package com.overdaily.Overdaily.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerGuessResponseDTO {
    private Integer id;
    private String heroPortrait;
    private String Name;
    private String Age;
    private String Gender;
    private String Health;
    private String Role;
    private String Affiliation;
    private String Composition;
    private String Composition2;
    private String LaunchYear;
    private String guessedHeroPortrait;
    private String guessedName;
    private Integer guessedAge;
    private String guessedGender;
    private Integer guessedHealth;
    private String guessedRole;
    private String guessedAffiliation;
    private String guessedComposition;
    private String guessedComposition2;
    private Integer guessedLaunchYear;
}
