package com.trokr.service;

import com.trokr.model.NivelLog;
import com.trokr.model.event.EventoRegistrado;
import com.trokr.port.RegistroDeEventos;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class LogEventoService {

    private final RegistroDeEventos registroDeEventos; //Chamada que faz a colinha do adapter

    public void registrarInfo(String tipo, String origem, String mensagem, Map<String, Object> payload) {
        registrarInfo(tipo, origem, mensagem, payload, null);
    }

    public void registrarInfo(String tipo, String origem, String mensagem,
                              Map<String, Object> payload, Long usuarioId) {
        registrar(NivelLog.INFO, tipo, origem, mensagem, payload, usuarioId);
    }

    public void registrarErro(String origem, String mensagem, Exception excecao) {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("excecao", excecao.getClass().getName());
        payload.put("mensagemExcecao", excecao.getMessage());
        StackTraceElement[] pilha = excecao.getStackTrace();
        if (pilha.length > 0) {
            payload.put("local", pilha[0].toString());
        }
        registrar(NivelLog.ERROR, "ERRO_SISTEMA", origem, mensagem, payload, null);
    }

    public List<EventoRegistrado> listarPorTipo(String tipo) {
        return registroDeEventos.buscarPorTipo(tipo);
    }

    private void registrar(NivelLog nivel, String tipo, String origem, String mensagem,
                           Map<String, Object> payload, Long usuarioId) {
        try {
            registroDeEventos.registrar(nivel, tipo, origem, mensagem, payload, usuarioId);
        } catch (Exception e) {
            log.warn("Não foi possível gravar o LogEvento (tipo={}, origem={}): {}",
                    tipo, origem, e.getMessage());
        }
    }
}