package com.overdaily.Overdaily.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "armas")

public class Gun {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Integer id;

    @Column(name = "Personagem_Arma", nullable = false)
    private String heroGun;

    @Column(name = "Imagem_Arma", nullable = false)
    private String gunPhoto;

    @Column(name = "Tipo_Arma", nullable = false)
    private String gunType;

    @Column(name = "Tipo_Tiro", nullable = false)
    private String ammoType;

    @Column(name = "Dano_Arma", nullable = false)
    private Integer gunDamage;

    @Column(name = "Headshot", nullable = false, columnDefinition = "TINYINT")
    private String headshot;

    @Column(name = "Municao", nullable = false)
    private Integer ammo;

    @Column(name = "Som_Arma", nullable = false)
    private String gunSound;
    





}