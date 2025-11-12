package com.overdaily.Overdaily.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@Table(name = "personagens")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hero {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "afiliacao_agente", nullable = false)
    private String heroAffiliation;

    @Column(name = "nome_agente", nullable = false)
    private String heroName;

    @Column(name = "nome_real_agente", nullable = false)
    private String heroRealName;

    @Column(name = "foto_agente", nullable = false)
    private String heroPhoto;

    @Column(name = "retrato_agente", nullable = false)
    private String heroPortrait;

    @Column(name = "vida_agente", nullable = false)
    private Integer heroHealth;

    @Column(name = "idade_agente", nullable = false)
    private Integer  heroAge;

    @Column(name = "genero_agente", nullable = false)
    private String heroGender;

    @Column(name = "pais_agente", nullable = false)
    private String heroCountry;

    @Column(name = "tipo_agente", nullable = false)
    private String heroRole;

    @Column(name = "comp_agente", nullable = false)
    private String heroComp;

    @Column(name = "comp_agente_2", nullable = false)
    private String heroComp2;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arma_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Gun heroGun;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habilidade_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ability heroAbility;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "falas_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Voiceline heroVoiceline;

    @Column(name = "ano_agente", nullable = false)
    private Integer heroYear;
}
