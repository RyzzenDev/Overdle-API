package com.overdaily.Overdaily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Habilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Short id;

    @Column(name = "Personagem_Habilidade", nullable = false)
    private String personagemHabilidade;

    @Column(name = "Habilidade_Passiva", nullable = false)
    private String habilidadePassiva;

    @Column(name = "Tipo_Habilidade1", nullable = false)
    private String tipoHabilidade1;

    @Column(name = "Tipo_Habilidade2", nullable = false)
    private String tipoHabilidade2;

    @Column(name = "Tipo_Habilidade3", nullable = false)
    private String tipoHabilidade3;

    @Column(name = "Som_Habilidade1", nullable = false)
    private String somHabilidade1;

    @Column(name = "Som_Habilidade2", nullable = false)
    private String somHabilidade2;

    @Column(name = "Som_Habilidade3", nullable = false)
    private String somHabilidade3;

    @Column(name = "Foto_Habilidade1", nullable = false)
    private String fotoHabilidade1;

    @Column(name = "Foto_Habilidade2", nullable = false)
    private String fotoHabilidade2;

    @Column(name = "Foto_Habilidade3", nullable = false)
    private String fotoHabilidade3;

    @Column(name = "Descricao_Habilidade1", nullable = false)
    private String descricaoHabilidade1;

    @Column(name = "Descricao_Habilidade2", nullable = false)
    private String descricaoHabilidade2;

    @Column(name = "Descricao_Habilidade3", nullable = false)
    private String descricaoHabilidade3;

    @Column(name = "Cooldown_Habilidade1", nullable = false)
    private Short cooldownHabilidade1;

    @Column(name = "Cooldown_Habilidade2", nullable = false)
    private Short cooldownHabilidade2;

    @Column(name = "Cooldown_Habilidade3", nullable = false)
    private Short cooldownHabilidade3;

}
