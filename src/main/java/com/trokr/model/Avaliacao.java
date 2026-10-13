package com.trokr.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "avaliacao",
       uniqueConstraints = @UniqueConstraint(columnNames = {"proposta_id", "usuario_autor_id"}))
@Getter
@NoArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer nota;

    @Column
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_autor_id", nullable = false)
    private Usuario usuarioAutor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_alvo_id", nullable = false)
    private Usuario usuarioAlvo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAvaliacao status = StatusAvaliacao.PENDENTE;

    public Avaliacao(Proposta proposta, Usuario usuarioAlvo, Usuario usuarioAutor) {
        if (usuarioAlvo.getId().equals(usuarioAutor.getId())) {
            throw new IllegalArgumentException("Não é possível avaliar a si mesmo");
        }
        this.proposta = proposta;
        this.usuarioAlvo = usuarioAlvo;
        this.usuarioAutor = usuarioAutor;
    }

    public void avaliar(Integer nota, String descricao) {
        if (status != StatusAvaliacao.PENDENTE) {
            throw new IllegalStateException("Só uma avaliação pendente pode ser avaliada");
        }
        if (nota == null || nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5");
        }
        this.nota = nota;
        this.descricao = descricao;
        this.status = StatusAvaliacao.AVALIADA;
    }

    public void atualizarDescricao(String descricao) {
        if (status != StatusAvaliacao.PENDENTE) {
            throw new IllegalStateException("Avaliação já avaliada não pode ser alterada");
        }
        this.descricao = descricao;
    }
}