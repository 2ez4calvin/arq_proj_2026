package com.trokr.dto;

import com.trokr.model.Proposta;
import java.time.LocalDateTime;
import com.trokr.model.StatusProposta;

/**
 * Dados de saída de um Proposta. Os dados do dono são achatados aqui
 * (usuarioId/usuarioNome) para manter o DTO simples, em vez de criar mais
 * uma classe aninhada só para isso.
 */
public record PropostaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String tipo,
        StatusProposta status,
        Long usuarioId,
        String usuarioNome,
        Long propostaPaiId,
        LocalDateTime dataCriacao) {

    public static PropostaResponseDTO fromEntity(Proposta proposta) {
        return new PropostaResponseDTO(
                proposta.getId(),
                proposta.getTitulo(),
                proposta.getDescricao(),
                proposta.getTipo(),
                proposta.getStatus(),
                proposta.getUsuario().getId(),
                proposta.getUsuario().getNome(),
                proposta.isContraProposta() ? proposta.getPropostaPai().getId() : null,
                proposta.getDataCriacao());
    }
}
