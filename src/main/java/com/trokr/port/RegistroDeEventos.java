package com.trokr.port;

import com.trokr.model.NivelLog;
import com.trokr.model.event.EventoRegistrado;

import java.util.List;
import java.util.Map;

//Interface que comunica 

public interface RegistroDeEventos {
 
    void registrar(NivelLog nivel, String tipo, String origem, String mensagem,
                   Map<String, Object> payload, Long usuarioId);
    List<EventoRegistrado> buscarPorTipo(String tipo);
}
 