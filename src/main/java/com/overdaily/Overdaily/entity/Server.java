package com.overdaily.Overdaily.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder
@Entity
@Data
@Table(name = "sistema")
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Timestamp")
    private OffsetDateTime timestamp;

    @Column(name = "Hero")
    private Integer hero;

    @Column(name = "Ability")
    private Integer ability;

    @Column(name = "Gun")
    private Integer gun;

    @Column(name = "Maps")
    private Integer maps;

    @Column(name = "Voiceline")
    private Integer voiceline;

    @Column(name = "Ultimate")
    private Integer ultimate;
}