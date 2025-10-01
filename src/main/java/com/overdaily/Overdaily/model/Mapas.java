package com.overdaily.Overdaily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Mapas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private int ID;

    @Column(name = "Tipo_Mapa", nullable = false)
    private String TipoMapa;

    @Column(name = "Pais_Mapa", nullable = false)
    private String PaisMapa;

    @Column(name = "Descricao_Mapa", nullable = false)
    private String DescricaoMapa;

    @Column(name = "Season_Mapa", nullable = false, columnDefinition = "TINYINT")
    private int SeasonMapa;

    @Column(name = "Versao_OW", nullable = false)
    private String VersaoOW;

    @Column(name = "Tema_Mapa", nullable = false)
    private String TemaMapa;

    @Column(name = "Imagem_Mapa", nullable = false)
    private String ImagemMapa;

}
