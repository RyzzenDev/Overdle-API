package com.overdaily.Overdaily.model;

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
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Integer id;

    @Column(name = "Tipo_Mapa", nullable = false)
    private String MapType;

    @Column(name = "Pais_Mapa", nullable = false)
    private String MapCountry;

    @Column(name = "Descricao_Mapa", nullable = false)
    private String MapDescription;

    @Column(name = "Season_Mapa", nullable = false, columnDefinition = "TINYINT")
    private Integer MapSeason;

    @Column(name = "Versao_OW", nullable = false)
    private String MapYear;

    @Column(name = "Tema_Mapa", nullable = false)
    private String MapThemeSong;

    @Column(name = "Imagem_Mapa", nullable = false)
    private String MapPhoto;

}
