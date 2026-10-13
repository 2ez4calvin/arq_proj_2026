package com.trokr.dto;
 
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
 
/**
 * Dados para concluir uma avaliação pendente.
 */
public record AvaliarRequestDTO(

        @NotNull(message = "usuarioAutorId é obrigatório")
        Long usuarioAutorId,
 
        @NotNull(message = "nota é obrigatoria para concluir a avaliacao")
        @Min(value = 1, message = "nota mínima é 1")
        @Max(value = 5, message = "nota máxima é 5")
        Integer nota,
 
        @NotNull(message = "Descricao é obrigatoria para concluir a avaliacao")
        String descricao
) {
}
 