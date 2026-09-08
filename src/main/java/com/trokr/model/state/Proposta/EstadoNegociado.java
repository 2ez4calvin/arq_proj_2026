package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoNegociado implements EstadoProposta {

    public void irParaRascunho(Item item) {

        throw new IllegalStateException("Transição Inválida!");
    }

    public void irParaHomologacao(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaAtiva(Item item) {

        item.mudarEstadoPara(new EstadoAtiva());

    }

    public void irParaNegociado(Item item) {

        throw new IllegalStateException("Já está como negociado. Transição inválida!");

    }

    public void irParaFinalizado(Item item) {

        item.mudarEstadoPara(new EstadoFinalizado());

    }

    public void irParaCancelado(Item item) {

        item.mudarEstadoPara(new EstadoCancelado());

    }

}
