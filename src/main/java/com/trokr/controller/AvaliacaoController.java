package com.trokr.controller;

import com.trokr.dto.AvaliacaoResponseDTO;
import com.trokr.dto.AvaliarRequestDTO;
import com.trokr.service.AvaliacaoService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public List<AvaliacaoResponseDTO> listar() {
        return avaliacaoService.listarTodas().stream()
                .map(AvaliacaoResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public AvaliacaoResponseDTO buscarPorId(@PathVariable Long id) {
        return AvaliacaoResponseDTO.fromEntity(avaliacaoService.buscarPorId(id));
    }

    @GetMapping("/proposta/{propostaId}")
    public List<AvaliacaoResponseDTO> listarPorProposta(@PathVariable Long propostaId) {
        return avaliacaoService.listarPorProposta(propostaId).stream()
                .map(AvaliacaoResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/usuario/{usuarioId}/recebidas")
    public List<AvaliacaoResponseDTO> listarRecebidas(@PathVariable Long usuarioId) {
        return avaliacaoService.listarRecebidas(usuarioId).stream()
                .map(AvaliacaoResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/usuario/{usuarioId}/feitas")
    public List<AvaliacaoResponseDTO> listarFeitas(@PathVariable Long usuarioId) {
        return avaliacaoService.listarFeitas(usuarioId).stream()
                .map(AvaliacaoResponseDTO::fromEntity)
                .toList();
    }

    @PatchMapping("/{id}")
    public AvaliacaoResponseDTO avaliar(@PathVariable Long id, @Valid @RequestBody AvaliarRequestDTO dto) {
        return AvaliacaoResponseDTO.fromEntity(avaliacaoService.avaliar(id, dto));
    }
}