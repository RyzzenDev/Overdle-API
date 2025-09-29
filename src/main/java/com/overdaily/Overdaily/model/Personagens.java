package com.overdaily.Overdaily.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Personagens")
public class Personagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, columnDefinition = "TINYINT")
    private Short ID;

    @Column(name = "Nome_Agente", nullable = false, unique = true, length = 100)
    private String NomeAgente;

    @Column(name = "Nome_Real_Agente", nullable = false, unique = true, length = 100)
    private String NomeRealAgente;

    @Column(name = "Idade_Agente", nullable = false, unique = false, columnDefinition = "TINYINT")
    private Short Idade;

    @Column(name = "Sexo_Agente", nullable = false, unique = false, length = 50)
    private String SexoAgente;

    @Column(name = "Pais_Agente", nullable = false, unique = false, length = 50)
    private String PaisAgente;

    @Column(name = "Tipo_Agente", nullable = false, unique = false, length = 20)
    private String TipoAgente;

    @Column(name = "Arma_Agente", nullable = false, unique = true, columnDefinition = "TINYINT")
    private Short ArmaAgente;

    @Column(name = "Falas_Agente", nullable = false, unique = true, columnDefinition = "TINYINT")
    private Short FalasAgente;

    @Column(name = "Season_Agente", nullable = false, unique = true, columnDefinition = "TINYINT")
    private Short SeasonAgente;


}
