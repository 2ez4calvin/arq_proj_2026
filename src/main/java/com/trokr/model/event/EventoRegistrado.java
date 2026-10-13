package com.trokr.model.event;
 
import com.trokr.model.NivelLog;
import java.time.LocalDateTime;
import java.util.Map;
 

public record EventoRegistrado(
        String tipo,
        NivelLog nivel,
        String origem,
        String mensagem,
        Map<String, Object> payload,
        LocalDateTime timestamp,
        Long usuarioId) {
}