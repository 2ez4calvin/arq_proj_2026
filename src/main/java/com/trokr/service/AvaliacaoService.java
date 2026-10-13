package com.trokr.service;

import com.trokr.dto.AvaliarRequestDTO;
import com.trokr.exception.OperacaoNaoPermitidaException;
import com.trokr.exception.ResourceNotFoundException;
import com.trokr.model.Avaliacao;
import com.trokr.repository.AvaliacaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * As avaliações NÃO são criadas aqui: nascem pendentes pelo
 * AtualizarAvaliacaoListener quando uma troca é concluída.
 * Este service só consulta e preenche.
 */
@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada com id " + id));
    }

    public List<Avaliacao> listarPorProposta(Long propostaId) {
        return avaliacaoRepository.findByPropostaId(propostaId);
    }

    public List<Avaliacao> listarRecebidas(Long usuarioId) {
        return avaliacaoRepository.findByUsuarioAlvoId(usuarioId);
    }

    public List<Avaliacao> listarFeitas(Long usuarioId) {
        return avaliacaoRepository.findByUsuarioAutorId(usuarioId);
    }

    @Transactional
    public Avaliacao avaliar(Long id, AvaliarRequestDTO dto) {
        Avaliacao avaliacao = buscarPorId(id);

        if (!avaliacao.getUsuarioAutor().getId().equals(dto.usuarioAutorId())) {
            throw new OperacaoNaoPermitidaException("Você não pode avaliar em nome de outra pessoa");
        }

        avaliacao.avaliar(dto.nota(), dto.descricao());
        return avaliacao;
    }
}