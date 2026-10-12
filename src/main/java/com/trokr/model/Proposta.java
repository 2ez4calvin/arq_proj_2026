package com.trokr.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import com.trokr.model.state.EstadoFactory;
import com.trokr.model.state.proposta.EstadoProposta;
import com.trokr.model.state.contraproposta.EstadoContraproposta;

@Entity
@Table(name = "proposta")
@Getter
/*
 * Removi o setter pois deixa qualquer um fazer setStatus,
 * independente do status. Alterar a lógica de status da proposta
 */
@NoArgsConstructor

public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProposta status = StatusProposta.RASCUNHO; // Define toda proposta inicialmente como rascunho

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Auto-relacionamento que faz a contraproposta ser diferente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposta_pai_id")
    private Proposta propostaPai;

    // Permite mapear todas as contrapropostas da proposta Pai
    @OneToMany(mappedBy = "propostaPai")
    private List<Proposta> contrapropostas = new ArrayList<>();

    @Transient
    private EstadoProposta estadoProposta;

    @Transient
    private EstadoContraproposta estadoContraproposta;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    public void atualizarDados(String titulo, String descricao, String tipo) {
        if (status != StatusProposta.RASCUNHO) {
            throw new IllegalStateException("Só é possível editar em rascunho");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Construtores
    public Proposta(String titulo, String descricao, String tipo, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.usuario = usuario;
        carregarEstado(); // status já é rascunho de padrão
    }

    public static Proposta criarContraProposta(String descricao, Usuario autor, Proposta pai) {
        Proposta contra = new Proposta(pai.titulo, descricao, pai.tipo, autor);
        contra.propostaPai = pai;
        contra.estadoProposta = null;
        contra.carregarEstado();
        pai.contrapropostas.add(contra);
        return contra;
    }

    public boolean isContraProposta() {
        return propostaPai != null;
    }

    @PostLoad // Conversão do status do BD para um objeto utilizado no model
    private void carregarEstado() {
        if (isContraProposta()) {
            this.estadoContraproposta = EstadoFactory.contraPropostaDe(status);
        } else {
            this.estadoProposta = EstadoFactory.propostaDe(status);
        }
    }

    public void mudarEstadoPara(EstadoProposta novoEstado) {
        if (isContraProposta()) {
            throw new IllegalStateException("Contraproposta não usa estados de Proposta");
        }
        this.estadoProposta = novoEstado;
        this.status = novoEstado.getStatus();
    }

    public void mudarEstadoPara(EstadoContraproposta novoEstado) {
        if (!isContraProposta()) {
            throw new IllegalStateException("Proposta não compartilha estados de ContraProposta");
        }
        this.estadoContraproposta = novoEstado;
        this.status = novoEstado.getStatus();
    }

    // ESTADOS DE PROPOSTA
    public void irParaRascunho() {
        exigirRaiz();
        estadoProposta.irParaRascunho(this);
    }

    public void irParaHomologacao() {
        exigirRaiz();
        estadoProposta.irParaHomologacao(this);
    }

    public void irParaAtiva() {
        exigirRaiz();
        estadoProposta.irParaAtiva(this);
    }

    public void irParaNegociado() {
        exigirRaiz();
        estadoProposta.irParaNegociado(this);
    }

    public void irParaFinalizado() {
        exigirRaiz();
        estadoProposta.irParaFinalizado(this);
    }

    public void irParaCancelado() {
        exigirRaiz();
        estadoProposta.irParaCancelado(this);
    }

    // ESTADOS DE CONTRAPROPOSTA
    public void contraIrParaRascunho() {
        exigirContra();
        estadoContraproposta.irParaRascunho(this);
    }

    public void contraIrParaEmAnalise() {
        exigirContra();
        estadoContraproposta.irParaEmAnalise(this);
    }

    public void contraIrParaNegociado() {
        exigirContra();
        estadoContraproposta.irParaNegociado(this);
    }

    public void contraIrParaFinalizado() {
        exigirContra();
        estadoContraproposta.irParaFinalizado(this);
    }

    public void contraIrParaRecusado() {
        exigirContra();
        estadoContraproposta.irParaRecusado(this);
    }

    public void contraIrParaCancelado() {
        exigirContra();
        estadoContraproposta.irParaCancelado(this);
    }

    // Camada de segurança extra, que evita nullpointerexception caso contra chame
    // um estado de proposta e vice-versa.
    private void exigirRaiz() {
        if (isContraProposta()) {
            throw new IllegalStateException("Operação válida apenas para Proposta");
        }
    }

    private void exigirContra() {
        if (!isContraProposta()) {
            throw new IllegalStateException("Operação válida apenas para Contraproposta");
        }
    }
}
