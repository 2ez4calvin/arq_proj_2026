package com.trokr.model;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "log_evento")
@Getter
@NoArgsConstructor
public class LogEvento {

    @Id
    private String id;                     // String pq eh ObjectId do mongo, int não funciona
    private String tipo;
    private NivelLog nivel;
    private String origem;
    private String mensagem;
    private Map<String, Object> payload;
    private LocalDateTime timestamp;
    private Long usuarioId;

    public LogEvento(String tipo, NivelLog nivel, String origem, String mensagem,
            Map<String, Object> payload, Long usuarioId) {
        this.tipo = tipo;
        this.nivel = nivel;
        this.origem = origem;
        this.mensagem = mensagem;
        this.payload = payload;
        this.usuarioId = usuarioId;
        this.timestamp = LocalDateTime.now();
    }
}
