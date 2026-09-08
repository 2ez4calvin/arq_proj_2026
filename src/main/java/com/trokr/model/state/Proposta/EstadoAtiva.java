package com.trokr.model.state.Proposta;

import com.trokr.model.Item;


public class EstadoAtiva implements EstadoProposta {

    public Item irParaRascunho(Item item) {

        item.mudarEstadoPara(new EstadoRascunho());
        return item;
    }

    public void irParaHomologacao(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaAtiva(Item item) {

        throw new IllegalStateException("Já está como ativa. Transição inválida!");

    }

    public Item irParaNegociado(Item item) {

        item.mudarEstadoPara(new EstadoNegociado());
        return item;

    }

    public void irParaFinalizado(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public Item irParaCancelado(Item item) {

        item.mudarEstadoPara(new EstadoCancelado());
        return item;

    }

    public boolean isPodeMudar(){
        return true;
    };
}
