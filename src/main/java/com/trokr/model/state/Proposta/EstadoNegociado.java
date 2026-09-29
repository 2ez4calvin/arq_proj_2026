package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoNegociado implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaHomologacao(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoAtiva());
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Já está como negociado. Transição inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoFinalizado());
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
