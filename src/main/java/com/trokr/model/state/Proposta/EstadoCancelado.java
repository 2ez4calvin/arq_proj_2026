package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoCancelado {

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
        throw new IllegalStateException("Já está como cancelado. Transição inválida!");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    };
}
