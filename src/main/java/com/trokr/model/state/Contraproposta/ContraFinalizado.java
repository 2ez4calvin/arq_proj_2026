package com.trokr.model.state.contraproposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public class ContraFinalizado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta contraproposta) {

        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta contraproposta) {
        throw new IllegalStateException("Já está como Finalizado. Transição inválida");
    }

    @Override
    public void irParaRecusado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.FINALIZADO_CONTRA;
    }

}
