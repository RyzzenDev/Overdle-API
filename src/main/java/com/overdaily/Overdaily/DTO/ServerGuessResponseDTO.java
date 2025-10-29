package com.overdaily.Overdaily.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerGuessResponseDTO {
    private String Name;
    private String Age;
    private String Gender;
    private String Health;
    private String Role;
    private String Affiliation;
    private String Composition;
    private String Composition2;
    private String LaunchYear;
    /*
    private String guessedName;
    private String guessedAge;
    private String guessedGender;
    private String guessedHealth;
    private String guessedRole;
    private String guessedAffiliation;
    private String guessedComposition;
    private String guessedComposition2;
    private String guessedLaunchYear;

     */


}
