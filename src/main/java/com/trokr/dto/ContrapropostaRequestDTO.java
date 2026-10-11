package com.trokr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContrapropostaRequestDTO(

        @NotBlank(message = "descricao é obrigatória")
        String descricao,

        @NotNull(message = "usuarioId é obrigatório")
        Long usuarioId
) {
}