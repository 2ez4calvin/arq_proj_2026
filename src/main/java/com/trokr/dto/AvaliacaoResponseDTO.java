package com.trokr.dto;

import com.trokr.model.Avaliacao;
import com.trokr.model.StatusAvaliacao;
import java.time.LocalDateTime;

/**
 * Dados da saída de uma avaliação
 */
public record AvaliacaoResponseDTO(
        Long id,
        Integer nota,
        String descricao,
        StatusAvaliacao status,
        Long propostaId,
        Long usuarioAutorId,
        String usuarioAutorNome,
        Long usuarioAlvoId,
        String usuarioAlvoNome,
        LocalDateTime dataCriacao) {

    public static AvaliacaoResponseDTO fromEntity(Avaliacao avaliacao) {
        return new AvaliacaoResponseDTO(
                avaliacao.getId(),
                avaliacao.getNota(),
                avaliacao.getDescricao(),
                avaliacao.getStatus(),
                avaliacao.getProposta().getId(),
                avaliacao.getUsuarioAutor().getId(),
                avaliacao.getUsuarioAutor().getNome(),
                avaliacao.getUsuarioAlvo().getId(),
                avaliacao.getUsuarioAlvo().getNome(),
                avaliacao.getDataCriacao());
    }
}