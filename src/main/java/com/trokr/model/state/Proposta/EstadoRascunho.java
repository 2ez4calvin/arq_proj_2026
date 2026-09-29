package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoRascunho implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaHomologacao(Proposta Proposta) {
        Proposta.mudarEstadoPara(new EstadoHomologacao());
    }

    @Override
    public void irParaAtiva(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
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
    }
}
