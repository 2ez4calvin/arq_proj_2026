package com.trokr.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "historico")
@Getter
@NoArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @Column(nullable = false)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProposta statusAnterior;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProposta statusNovo;

    @Column(nullable = false)
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Historico(Proposta proposta, String motivo, StatusProposta statusAnterior,
                     StatusProposta statusNovo, Usuario usuario, LocalDateTime data) {
        this.proposta = proposta;
        this.motivo = motivo;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
        this.usuario = usuario;
        this.data = data;
    }
}