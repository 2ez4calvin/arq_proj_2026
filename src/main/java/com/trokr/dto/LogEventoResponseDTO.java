package com.trokr.dto;

import com.trokr.model.NivelLog;
import com.trokr.model.event.EventoRegistrado;

import java.time.LocalDateTime;
import java.util.Map;

public record LogEventoResponseDTO(
        String tipo,
        NivelLog nivel,
        String origem,
        String mensagem,
        Map<String, Object> payload,
        LocalDateTime timestamp,
        Long usuarioId) {

    public static LogEventoResponseDTO fromEvento(EventoRegistrado evento) {
        return new LogEventoResponseDTO(
                evento.tipo(),
                evento.nivel(),
                evento.origem(),
                evento.mensagem(),
                evento.payload(),
                evento.timestamp(),
                evento.usuarioId());
    }
}