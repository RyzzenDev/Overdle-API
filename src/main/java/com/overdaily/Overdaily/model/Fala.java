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
public class Fala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Short ID;

    @Column(name = "Personagem_Fala", nullable = false)
    private String PersonagemFala;

    @Column(name = "Fala_Facil", nullable = false)
    private String FalaFacil;

    @Column(name = "Fala_Media", nullable = false)
    private String FalaMedia;

    @Column(name = "Fala_Dificil", nullable = false)
    private String FalaDificil;

    @Column(name = "Audio_Facil", nullable = false)
    private String AudioFacil;

    @Column(name = "Audio_Media", nullable = false)
    private String AudioMedia;

    @Column(name = "Audio_Dificil", nullable = false)
    private String AudioDificil;



}
