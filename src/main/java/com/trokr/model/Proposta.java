package com.trokr.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "proposta")
@Getter
@Setter /*Verificar depois, pois o setter deixa qualquer um fazer setStatus, 
independente do status. Alterar a lógica de status da proposta*/
@NoArgsConstructor
@AllArgsConstructor

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
    private StatusProposta status = StatusProposta.RASCUNHO;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Auto-relacionamento que faz a contraproposta ser diferente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposta_pai_id")
    private Proposta propostaPai;

    //Permite mapear todas as contrapropostas da proposta Pai
    @OneToMany(mappedBy = "propostaPai")
    private List<Proposta> contrapropostas = new ArrayList<>();


    public Proposta(String titulo, String descricao, String tipo, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.usuario = usuario;
    }


    public static Proposta criarContraProposta(String descricao, Usuario autor, Proposta origem) {
        Proposta contra = new Proposta(origem.titulo, descricao, origem.tipo, autor);
        contra.propostaOrigem = origem;
        origem.contrapropostas.add(contra);
        return contra;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public boolean isContraProposta() {
        return propostaPai != null;
    }
}
