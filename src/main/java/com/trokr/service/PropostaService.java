package com.trokr.service;

import com.trokr.exception.ResourceNotFoundException;
import com.trokr.model.Proposta;
import com.trokr.model.Usuario;
import com.trokr.repository.PropostaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository PropostaRepository;
    private final UsuarioService usuarioService;

    public List<Proposta> listarTodos() {
        return PropostaRepository.findAll();
    }

    public Proposta buscarPorId(Long id) {
        return PropostaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proposta não encontrado com id " + id));
    }

    public List<Proposta> listarPorTitulo(String titulo) {
        return PropostaRepository.findByTituloContainingIgnoreCase(titulo);
    }
    public List<Proposta> listarPorTipo(String tipo) {
        return PropostaRepository.findByTipoIgnoreCase(tipo);
    }
    public List<Proposta> listarPorUsuarioProprietario(Long usuarioId) {
        return PropostaRepository.findByUsuarioProprietarioId(usuarioId);
    }

    public Proposta criar(Proposta Proposta, Long usuarioId) {
        Usuario dono = usuarioService.buscarPorId(usuarioId);
        Proposta.setUsuarioProprietario(dono);
        return PropostaRepository.save(Proposta);
    }

    public Proposta atualizar(Long id, Proposta dadosAtualizados, Long usuarioId) {
        Proposta PropostaExistente = buscarPorId(id);
        Usuario dono = usuarioService.buscarPorId(usuarioId);
        PropostaExistente.setTitulo(dadosAtualizados.getTitulo());
        PropostaExistente.setDescricao(dadosAtualizados.getDescricao());
        PropostaExistente.setTipo(dadosAtualizados.getTipo());
        PropostaExistente.setUsuarioProprietario(dono);
        return PropostaRepository.save(PropostaExistente);
    }

    public void remover(Long id) {
        Proposta Proposta = buscarPorId(id);
        PropostaRepository.delete(Proposta);
    }
}