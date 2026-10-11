package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoHomologacao implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoRascunho());
    }

    @Override
    public void irParaHomologacao(Proposta proposta) {
        throw new IllegalStateException("Já está como homologação. Transição inválida!");
    }

    @Override
    public void irParaAtiva(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoAtiva());
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
        proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }
}
