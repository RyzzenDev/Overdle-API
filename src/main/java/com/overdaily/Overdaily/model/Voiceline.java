package com.overdaily.Overdaily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "falas")
public class Voiceline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Integer id;

    @Column(name = "Personagem_Fala", nullable = false)
    private String HeroVoiceline;

    @Column(name = "Fala_Facil", nullable = false)
    private String EasyVoiceline;

    @Column(name = "Fala_Media", nullable = false)
    private String MediumVoiceline;

    @Column(name = "Fala_Dificil", nullable = false)
    private String HardVoiceline;

    @Column(name = "Audio_Facil", nullable = false)
    private String EasyAudio;

    @Column(name = "Audio_Media", nullable = false)
    private String MediumAudio;

    @Column(name = "Audio_Dificil", nullable = false)
    private String HardAudio;



}
