package com.trokr.model.state.proposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public class EstadoAtiva implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoRascunho());
    }

    @Override
    public void irParaHomologacao(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Proposta proposta) {
        throw new IllegalStateException("Já está como ativa. Transição inválida!");
    }

    @Override
    public void irParaNegociado(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoNegociado());
    }

    @Override
    public void irParaFinalizado(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    };

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.ATIVA;
    }
}
