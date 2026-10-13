package com.trokr.model.listener;

import com.trokr.model.event.TrocaConcluidaEvent;
import com.trokr.service.LogEventoService;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class RegistrarLogEventoListener {

    private final LogEventoService logEventoService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true)
    public void aoConcluirTroca(TrocaConcluidaEvent evento) {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("propostaId", evento.propostaId());
        payload.put("usuarioRaizId", evento.usuarioRaiz().getId());
        payload.put("usuarioContraId", evento.usuarioContra().getId());
        payload.put("dataConclusao", evento.dataConclusao().toString());

        // Dois usuários envolvidos: ficam no payload, e usuarioId fica nulo
        logEventoService.registrarInfo("TROCA_CONCLUIDA", "PropostaService", "Troca concluída", payload);
    }
}