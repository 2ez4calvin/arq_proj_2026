package com.trokr.service;

import com.trokr.dto.ContrapropostaRequestDTO;
import com.trokr.dto.PropostaRequestDTO;
import com.trokr.exception.ResourceNotFoundException;
import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;
import com.trokr.model.Usuario;
import com.trokr.repository.PropostaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final UsuarioService usuarioService;

    public List<Proposta> listarTodos() {
        return propostaRepository.findAll();
    }

    public Proposta buscarPorId(Long id) {
        return propostaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proposta não encontrada com id " + id));
    }

    public List<Proposta> listarPorTitulo(String titulo) {
        return propostaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Proposta> listarPorTipo(String tipo) {
        return propostaRepository.findByTipoIgnoreCase(tipo);
    }

    public List<Proposta> listarPorUsuario(Long usuarioId) {
        return propostaRepository.findByUsuarioId(usuarioId);
    }

    public List<Proposta> listarContrapropostas(Long propostaPaiId) {
        return buscarPorId(propostaPaiId).getContrapropostas();
    }

    @Transactional // Garante segurança no salvamento e atomicidade
    public Proposta criar(PropostaRequestDTO dto) {
        Usuario dono = usuarioService.buscarPorId(dto.usuarioId());
        Proposta proposta = new Proposta(dto.titulo(), dto.descricao(), dto.tipo(), dono);
        return propostaRepository.save(proposta);
    }

    @Transactional
    public Proposta criarContraproposta(Long propostaPaiId, ContrapropostaRequestDTO dto) {
        Proposta pai = buscarPorId(propostaPaiId);
        Usuario autor = usuarioService.buscarPorId(dto.usuarioId());

        if (pai.isContraProposta()) {
            throw new IllegalStateException("Não é possível contrapropor uma contraproposta");
        }
        if (pai.getStatus() != StatusProposta.ATIVA) {
            throw new IllegalStateException("Só é possível contrapropor uma proposta ativa");
        }
        if (pai.getUsuario().getId().equals(autor.getId())) {
            throw new IllegalStateException("O dono não pode contrapropor a própria proposta");
        }

        Proposta contra = Proposta.criarContraProposta(dto.descricao(), autor, pai);
        return propostaRepository.save(contra);
    }

    @Transactional
    public Proposta atualizar(Long id, PropostaRequestDTO dto) {
        Proposta proposta = buscarPorId(id);
        proposta.atualizarDados(dto.titulo(), dto.descricao(), dto.tipo());
        return proposta;
    }

    @Transactional
    public void remover(Long id) {
        propostaRepository.delete(buscarPorId(id));
    }

    // Mudanças de Estado de proposta

    @Transactional
    public Proposta irParaRascunho(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaRascunho();
        return proposta;
    }

    @Transactional
    public Proposta irParaHomologacao(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaHomologacao();
        return proposta;
    }

    @Transactional
    public Proposta irParaAtiva(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaAtiva();
        return proposta;
    }

    @Transactional
    public Proposta irParaCancelado(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaCancelado();
        return proposta;
    }

    @Transactional
    public Proposta irParaNegociado(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaNegociado();
        return proposta;
    }

    @Transactional
    public Proposta irParaFinalizado(Long id) {
        Proposta proposta = buscarPorId(id);
        proposta.irParaFinalizado();
        return proposta;
    }

    // Mudanças de Estado para contraproposta

    @Transactional
    public Proposta contraEmAnalise(Long id) {
        Proposta contra = buscarPorId(id);
        contra.contraIrParaEmAnalise();
        return contra;
    }

    @Transactional
    public Proposta contraNegociar(Long id) {
        Proposta contra = buscarPorId(id);
        contra.contraIrParaNegociado();
        return contra;
    }

    @Transactional
    public Proposta contraFinalizar(Long id) {
        Proposta contra = buscarPorId(id);
        contra.contraIrParaFinalizado();
        return contra;
    }

    @Transactional
    public Proposta contraRecusar(Long id) {
        Proposta contra = buscarPorId(id);
        contra.contraIrParaRecusado();
        return contra;
    }

    @Transactional
    public Proposta contraCancelar(Long id) {
        Proposta contra = buscarPorId(id);
        contra.contraIrParaCancelado();
        return contra;
    }
}