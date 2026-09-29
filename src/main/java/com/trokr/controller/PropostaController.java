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

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService PropostaService;

    @GetMapping
    public List<PropostaResponseDTO> listar() {
        return PropostaService.listarTodos().stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public PropostaResponseDTO buscarPorId(@PathVariable Long id) {
        return PropostaResponseDTO.fromEntity(PropostaService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public List<PropostaResponseDTO> listarPorTitulo(@RequestParam("titulo") String titulo){
        return PropostaService.listarPorTitulo(titulo).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/buscar-tipo")
    public List<PropostaResponseDTO> listarPorTipo(@RequestParam("tipo") String tipo){
        return PropostaService.listarPorTipo(tipo).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/buscar-itens-usuario/{id}")
    public List<PropostaResponseDTO> listarPorProprietario(@PathVariable Long id){
        return PropostaService.listarPorUsuarioProprietario(id).stream()
                .map(PropostaResponseDTO::fromEntity)
                .toList();
    }

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@Valid @RequestBody PropostaRequestDTO dto) {
        Proposta Proposta = new Proposta();
        Proposta.setTitulo(dto.titulo());
        Proposta.setDescricao(dto.descricao());
        Proposta.setTipo(dto.tipo());

        Proposta salvo = PropostaService.criar(Proposta, dto.usuarioId());
        return ResponseEntity.status(HttpStatus.CREATED).body(PropostaResponseDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public PropostaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PropostaRequestDTO dto) {
        Proposta dadosAtualizados = new Proposta();
        dadosAtualizados.setTitulo(dto.titulo());
        dadosAtualizados.setDescricao(dto.descricao());
        dadosAtualizados.setTipo(dto.tipo());

        return PropostaResponseDTO.fromEntity(PropostaService.atualizar(id, dadosAtualizados, dto.usuarioId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        PropostaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
