package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoRascunho implements EstadoProposta {

    public void irParaRascunho(Item item){

        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    public void irParaHomologacao(Item item) {

        item.mudarEstadoPara(new EstadoHomologacao());

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

        item.mudarEstadoPara(new EstadoCancelado());

    }

}
