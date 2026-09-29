package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoAtiva implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoRascunho());
    }

    @Override
    public void irParaHomologacao(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Proposta Proposta) {
        throw new IllegalStateException("Já está como ativa. Transição inválida!");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoNegociado());
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    };
}
