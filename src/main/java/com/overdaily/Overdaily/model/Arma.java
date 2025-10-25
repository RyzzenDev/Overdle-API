package com.overdaily.Overdaily.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "armas")

public class Arma {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Integer id;

    @Column(name = "Personagem_Arma", nullable = false)
    private String PersonagemArma;

    @Column(name = "Imagem_Arma", nullable = false)
    private String ImagemArma;

    @Column(name = "Tipo_Arma", nullable = false)
    private String TipoArma;

    @Column(name = "Tipo_Tiro", nullable = false)
    private String TipoTiro;

    @Column(name = "Dano_Arma", nullable = false)
    private Integer DanoArma;

    @Column(name = "Headshot", nullable = false, columnDefinition = "TINYINT")
    private String Headshot;

    @Column(name = "Municao", nullable = false)
    private Integer Municao;

    @Column(name = "Som_Arma", nullable = false)
    private String SomArma;
    





}