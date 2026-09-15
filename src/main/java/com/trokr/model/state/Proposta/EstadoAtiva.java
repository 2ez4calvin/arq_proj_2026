package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoAtiva implements EstadoProposta {

    @Override
    public void irParaRascunho(Item item) {
        item.mudarEstadoPara(new EstadoRascunho());
    }

    @Override
    public void irParaHomologacao(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Item item) {
        throw new IllegalStateException("Já está como ativa. Transição inválida!");
    }

    @Override
    public void irParaNegociado(Item item) {
        item.mudarEstadoPara(new EstadoNegociado());
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
    };
}
