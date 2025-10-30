package com.overdaily.Overdaily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habilidades")

public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Integer id;

    @Column(name = "Personagem_Habilidade", nullable = false)
    private String  heroAbility;

    @Column(name = "Habilidade_Passiva", nullable = false)
    private String  heroPassive;

    @Column(name = "Tipo_Habilidade1", nullable = false)
    private String  abilityType1;

    @Column(name = "Tipo_Habilidade2", nullable = false)
    private String  abilityType2;

    @Column(name = "Tipo_Habilidade3", nullable = false)
    private String  abilityType3;

    @Column(name = "Som_Habilidade1", nullable = false)
    private String  abilitySound1;

    @Column(name = "Som_Habilidade2", nullable = false)
    private String  abilitySound2;

    @Column(name = "Som_Habilidade3", nullable = false)
    private String  abilitySound3;

    @Column(name = "Foto_Habilidade1", nullable = false)
    private String  abilityPhoto1;

    @Column(name = "Foto_Habilidade2", nullable = false)
    private String  abilityPhoto2;

    @Column(name = "Foto_Habilidade3", nullable = false)
    private String  abilityPhoto3;

    @Column(name = "Descricao_Habilidade1", nullable = false)
    private String  abilityInfo1;

    @Column(name = "Descricao_Habilidade2", nullable = false)
    private String  abilityInfo2;

    @Column(name = "Descricao_Habilidade3", nullable = false)
    private String  abilityInfo3;

    @Column(name = "Cooldown_Habilidade1", nullable = false)
    private Short   abilityCooldown1;

    @Column(name = "Cooldown_Habilidade2", nullable = false)
    private Short   abilityCooldown2;

    @Column(name = "Cooldown_Habilidade3", nullable = false)
    private Short   abilityCooldown3;

}
