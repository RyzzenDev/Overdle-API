package com.overdaily.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mapas")

public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Tipo_Mapa", nullable = false)
    private String mapType;

    @Column(name = "Pais_Mapa", nullable = false)
    private String mapCountry;

    @Column(name = "Descricao_Mapa", nullable = false)
    private String mapDescription;

    @Column(name = "Season_Mapa", nullable = false, columnDefinition = "TINYINT")
    private Integer mapSeason;

    @Column(name = "Versao_OW", nullable = false)
    private String mapYear;

    @Column(name = "Tema_Mapa", nullable = false)
    private String mapThemeSong;

    @Column(name = "Imagem_Mapa", nullable = false)
    private String mapPhoto;

}
