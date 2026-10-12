package com.trokr.model.state.proposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public class EstadoCancelado implements EstadoProposta{

    @Override
    public void irParaRascunho(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaHomologacao(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta proposta) {
        throw new IllegalStateException("Já está como cancelado. Transição inválida!");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    };

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.CANCELADO_RAIZ;
    }
}
