package com.overdaily.entity;

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
    private Integer id;

    @Column(name = "Personagem_Fala", nullable = false)
    private String heroVoiceline;

    @Column(name = "Fala_Facil", nullable = false)
    private String easyVoiceline;

    @Column(name = "Fala_Media", nullable = false)
    private String mediumVoiceline;

    @Column(name = "Fala_Dificil", nullable = false)
    private String mardVoiceline;

    @Column(name = "Audio_Facil", nullable = false)
    private String masyAudio;

    @Column(name = "Audio_Media", nullable = false)
    private String mediumAudio;

    @Column(name = "Audio_Dificil", nullable = false)
    private String hardAudio;



}
