package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public class ContraCancelado implements EstadoContraproposta {

    @Override
    public void irParaRascunho(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaNegociado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaFinalizado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaRecusado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaCancelado(Proposta contraproposta) {
        throw new IllegalStateException("Já está como Cancelado. Transição inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

}
