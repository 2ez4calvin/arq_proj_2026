package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoNegociado implements EstadoProposta {

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
        proposta.mudarEstadoPara(new EstadoAtiva());
    }

    @Override
    public void irParaNegociado(Proposta proposta) {
        throw new IllegalStateException("Já está como negociado. Transição inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoFinalizado());
    }

    @Override
    public void irParaCancelado(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
