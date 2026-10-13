package com.trokr.model.event;

import java.time.LocalDateTime;
import com.trokr.model.Usuario;

public record TrocaConcluidaEvent(
    Long propostaId,
    Usuario usuarioRaiz,
    Usuario usuarioContra,
    LocalDateTime dataConclusao) {
}
