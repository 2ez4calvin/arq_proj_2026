package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoNegociado implements EstadoProposta {

    @Override
    public void irParaRascunho(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaHomologacao(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Item item) {
        item.mudarEstadoPara(new EstadoAtiva());
    }

    @Override
    public void irParaNegociado(Item item) {
        throw new IllegalStateException("Já está como negociado. Transição inválida!");
    }

    @Override
    public void irParaFinalizado(Item item) {
        item.mudarEstadoPara(new EstadoFinalizado());
    }

    @Override
    public void irParaCancelado(Item item) {
        item.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
