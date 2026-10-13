package com.trokr.controller;
 
import com.trokr.dto.LogEventoResponseDTO;
import com.trokr.service.LogEventoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogEventoController {
 
    private final LogEventoService logEventoService;
 
    @GetMapping
    public List<LogEventoResponseDTO> listarPorTipo(@RequestParam("tipo") String tipo) {
        return logEventoService.listarPorTipo(tipo).stream()
                .map(LogEventoResponseDTO::fromEvento)
                .toList();
    }
}
 