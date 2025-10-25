package com.overdaily.Overdaily.model;

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
public class Personagem {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "afiliacao_agente", nullable = false)
    private String afiliacaoAgente;

    @Column(name = "nome_agente", nullable = false)
    private String nomeAgente;

    @Column(name = "nome_real_agente", nullable = false)
    private String nomeRealAgente;

    @Column(name = "foto_agente", nullable = false)
    private String fotoAgente;

    @Column(name = "vida_agente", nullable = false)
    private Integer vidaAgente;

    @Column(name = "idade_agente", nullable = false)
    private Short idadeAgente;

    @Column(name = "genero_agente", nullable = false)
    private String generoAgente;

    @Column(name = "pais_agente", nullable = false)
    private String paisAgente;

    @Column(name = "tipo_agente", nullable = false)
    private String tipoAgente;

    @Column(name = "comp_agente", nullable = false)
    private String compAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arma_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Arma armaAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habilidade_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habilidade habilidadeAgente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "falas_agente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fala falasAgente;

    @Column(name = "ano_agente", nullable = false)
    private Integer anoAgente;
}
