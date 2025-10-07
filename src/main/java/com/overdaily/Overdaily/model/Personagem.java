package com.overdaily.Overdaily.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "personagens")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Personagem {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Nome_Agente", nullable = false)
    private String nomeAgente;

    @Column(name = "Nome_Real_Agente", nullable = false)
    private String nomeRealAgente;

    @Column(name = "Foto_Agente", nullable = false)
    private String fotoAgente;

    @Column(name = "Vida_Agente", nullable = false)
    private Integer vidaAgente;

    @Column(name = "Idade_Agente", nullable = false)
    private Short idadeAgente;

    @Column(name = "Sexo_Agente", nullable = false)
    private String sexoAgente;

    @Column(name = "Pais_Agente", nullable = false)
    private String paisAgente;

    @Column(name = "Tipo_Agente", nullable = false)
    private String tipoAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Arma_Agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Arma armaAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Habilidade_Agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habilidade habilidadeAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Falas_Agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fala falasAgente;

    @Column(name = "Season_Agente", nullable = false)
    private Short seasonAgente;

    @Column(name = "Versao_OW", nullable = false)
    private String versaoOw;
}
