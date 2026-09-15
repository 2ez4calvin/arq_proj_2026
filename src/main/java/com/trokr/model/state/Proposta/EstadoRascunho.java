package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoRascunho implements EstadoProposta {

    @Override
    public void irParaRascunho(Item item) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaHomologacao(Item item) {
        item.mudarEstadoPara(new EstadoHomologacao());
    }

    @Override
    public void irParaAtiva(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
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
