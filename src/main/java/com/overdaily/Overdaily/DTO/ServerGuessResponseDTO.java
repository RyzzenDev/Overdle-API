package com.overdaily.Overdaily.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerGuessResponseDTO {
    private String name;
    private String age;
    private String gender;
    private String health;
    private String role;
    private String affiliation;
    private String Composition;
    private String LaunchYear;
}
