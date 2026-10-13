package com.trokr.model.listener;

import com.trokr.model.event.TrocaConcluidaEvent;
import com.trokr.model.Historico;
import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;
import com.trokr.repository.HistoricoRepository;
import com.trokr.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RegistrarHistoricoListener {

    private final HistoricoRepository historicoRepository;
    private final PropostaRepository propostaRepository;

    @EventListener
    public void aoConcluirTroca(TrocaConcluidaEvent evento) {
        Proposta proposta = propostaRepository.getReferenceById(evento.propostaId());

        Historico registro = new Historico(
                proposta,
                "Troca concluída",
                StatusProposta.NEGOCIADO_RAIZ,
                StatusProposta.FINALIZADO,
                evento.usuarioRaiz(),
                evento.dataConclusao());

        historicoRepository.save(registro);
    }
}