package com.trokr.dto;

import com.trokr.model.Proposta;
import java.time.LocalDateTime;

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
        Long usuarioId,
        String usuarioNome,
        LocalDateTime dataCriacao
) {

    public static PropostaResponseDTO fromEntity(Proposta Proposta) {
        return new PropostaResponseDTO(
                Proposta.getId(),
                Proposta.getTitulo(),
                Proposta.getDescricao(),
                Proposta.getTipo(),
                Proposta.getUsuarioProprietario().getId(),
                Proposta.getUsuarioProprietario().getNome(),
                Proposta.getDataCriacao()
        );
    }
}
