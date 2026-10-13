package com.trokr.adapter;

import com.trokr.model.LogEvento;
import com.trokr.model.NivelLog;
import com.trokr.model.event.EventoRegistrado;
import com.trokr.port.RegistroDeEventos;
import com.trokr.repository.LogEventoRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * ADAPTADOR: Só aqui existe o conhecimento da linguagem que comunica com o mongo
 * especificamente falando. Cumpre a interface - Spring vai entregar isso automaticamente para o service 
 */
@Component //Aqui que faz O adapter encontrar o service
@RequiredArgsConstructor
public class RegistroDeEventosMongo implements RegistroDeEventos {

    private final LogEventoRepository mongoRepository;

    @Override
    public void registrar(NivelLog nivel, String tipo, String origem, String mensagem,
                          Map<String, Object> payload, Long usuarioId) {
        mongoRepository.insert(new LogEvento(tipo, nivel, origem, mensagem, payload, usuarioId));
    }

    @Override
    public List<EventoRegistrado> buscarPorTipo(String tipo) {
        return mongoRepository.findByTipoOrderByTimestampDesc(tipo).stream()
                .map(doc -> new EventoRegistrado(
                        doc.getTipo(), doc.getNivel(), doc.getOrigem(), doc.getMensagem(),
                        doc.getPayload(), doc.getTimestamp(), doc.getUsuarioId()))
                .toList();
    }
}