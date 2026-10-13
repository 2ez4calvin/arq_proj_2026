package com.trokr.model.listener;

import com.trokr.model.event.TrocaConcluidaEvent;
import com.trokr.model.Avaliacao;
import com.trokr.model.Proposta;
import com.trokr.repository.AvaliacaoRepository;
import com.trokr.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Cria ambas as avaliações pendentes.
 */
@Component
@RequiredArgsConstructor
public class AtualizarAvaliacaoListener {

    private final AvaliacaoRepository avaliacaoRepository;
    private final PropostaRepository propostaRepository;

    @EventListener
    public void aoConcluirTroca(TrocaConcluidaEvent evento) {
        Proposta proposta = propostaRepository.getReferenceById(evento.propostaId());

        // A avalia B
        Avaliacao raizParaContra = new Avaliacao(proposta, evento.usuarioContra(), evento.usuarioRaiz());
        // B avalia A
        Avaliacao contraParaRaiz = new Avaliacao(proposta, evento.usuarioRaiz(), evento.usuarioContra());

        avaliacaoRepository.save(raizParaContra);
        avaliacaoRepository.save(contraParaRaiz);
    }
}