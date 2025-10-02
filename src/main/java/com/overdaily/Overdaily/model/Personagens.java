package com.overdaily.Overdaily.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Personagens")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Personagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "TINYINT")
    private Short id;

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
    private Armas armaAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Habilidade_Agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habilidades habilidadeAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Falas_Agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Falas falasAgente;

    @Column(name = "Season_Agente", nullable = false)
    private Short seasonAgente;

    @Column(name = "Versao_OW", nullable = false)
    private String versaoOw;
}
