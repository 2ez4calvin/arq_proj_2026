package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoHomologacao implements EstadoProposta {

    public item irParaRascunho(Item item) {

        item.mudarEstadoPara(new EstadoRascunho());
    }

    public void irParaHomologacao(Item item) {

        throw new IllegalStateException("Já está como homologação. Transição inválida!");

    }

    public void irParaAtiva(Item item) {

        item.mudarEstadoPara(new EstadoAtiva());

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
