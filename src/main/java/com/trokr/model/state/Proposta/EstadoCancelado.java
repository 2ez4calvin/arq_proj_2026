package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoCancelado {

    public void irParaRascunho(Item item) {

        throw new IllegalStateException("Transição Inválida!");
    }

    public void irParaHomologacao(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaAtiva(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaNegociado(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaFinalizado(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaCancelado(Item item) {

        throw new IllegalStateException("Já está como cancelado. Transição inválida!");

    }

    public boolean isPodeMudar(){
        return false;
    };
}
