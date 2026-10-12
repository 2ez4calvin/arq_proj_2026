package com.trokr.controller;

import com.trokr.dto.PropostaRequestDTO;
import com.trokr.dto.PropostaResponseDTO;
import com.trokr.model.Proposta;
import com.trokr.service.PropostaService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trokr.dto.ContrapropostaRequestDTO;

@RestController
@RequestMapping("/propostas")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService propostaService;

    @GetMapping
    public List<PropostaResponseDTO> listar() {
        return propostaService.listarTodos().stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public PropostaResponseDTO buscarPorId(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public List<PropostaResponseDTO> listarPorTitulo(@RequestParam("titulo") String titulo) {
        return propostaService.listarPorTitulo(titulo).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/buscar-tipo")
    public List<PropostaResponseDTO> listarPorTipo(@RequestParam("tipo") String tipo) {
        return propostaService.listarPorTipo(tipo).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/usuario/{id}")
    public List<PropostaResponseDTO> listarPorUsuario(@PathVariable Long id) {
        return propostaService.listarPorUsuario(id).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@Valid @RequestBody PropostaRequestDTO dto) {
        Proposta salva = propostaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(PropostaResponseDTO.fromEntity(salva));
    }

    @PostMapping("/{id}/contrapropostas")
    public ResponseEntity<PropostaResponseDTO> criarContraproposta(
            @PathVariable Long id, @Valid @RequestBody ContrapropostaRequestDTO dto) {
        Proposta contra = propostaService.criarContraproposta(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(PropostaResponseDTO.fromEntity(contra));
    }

    @GetMapping("/{id}/contrapropostas")
    public List<PropostaResponseDTO> listarContrapropostas(@PathVariable Long id) {
        return propostaService.listarContrapropostas(id).stream()
                .map(PropostaResponseDTO::fromEntity).toList();
    }

    @PutMapping("/{id}")
    public PropostaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PropostaRequestDTO dto) {
        return PropostaResponseDTO.fromEntity(propostaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        propostaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    // Mudanças de Estado de proposta
    @PatchMapping("/{id}/homologar")
    public PropostaResponseDTO homologar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaHomologacao(id));
    }

    @PatchMapping("/{id}/ativar")
    public PropostaResponseDTO ativar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaAtiva(id));
    }

    @PatchMapping("/{id}/cancelar")
    public PropostaResponseDTO cancelar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaCancelado(id));
    }

    @PatchMapping("/{id}/rascunho")
    public PropostaResponseDTO rascunho(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaRascunho(id));
    }

    @PatchMapping("/{id}/negociar")
    public PropostaResponseDTO negociar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaNegociado(id));
    }

    @PatchMapping("/{id}/finalizar")
    public PropostaResponseDTO finalizar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaFinalizado(id));
    }

    // Mudanças de Estado de contraproposta
    @PatchMapping("contraproposta/{id}/rascunho")
    public PropostaResponseDTO contraRascunho(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.irParaRascunho(id));
    }

    @PatchMapping("contraproposta/{id}/analisar")
    public PropostaResponseDTO contraAnalisar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.contraEmAnalise(id));
    }

    @PatchMapping("contraproposta/{id}/cancelar")
    public PropostaResponseDTO contraCancelar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.contraCancelar(id));
    }

    @PatchMapping("contraproposta/{id}/finalizar")
    public PropostaResponseDTO contraFinalizar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.contraFinalizar(id));
    }

    @PatchMapping("contraproposta/{id}/negociar")
    public PropostaResponseDTO contraNegociar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.contraNegociar(id));
    }

    @PatchMapping("contraproposta/{id}/recusar")
    public PropostaResponseDTO contraRecusar(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(propostaService.contraRecusar(id));
    }
}
