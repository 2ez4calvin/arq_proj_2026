package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public class ContraRecusado implements EstadoContraproposta {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaRecusado(Proposta Proposta) {
        throw new IllegalStateException("Já está como Recusado. Transição inválida");
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

}