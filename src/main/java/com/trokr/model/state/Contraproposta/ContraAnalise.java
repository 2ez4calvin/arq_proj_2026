package com.trokr.model.state.Contraproposta;

import com.trokr.model.Item;

public class ContraAnalise implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Item item) {
        item.mudarEstadoPara(new ContraRascunho());
    }

    @Override
    public void irParaEmAnalise(Item item) {

        throw new IllegalStateException("Já está como Em análise. Transição inválida");
    }

    @Override
    public void irParaNegociado(Item item) {
        item.mudarEstadoPara(new ContraNegociado());
    }

    @Override
    public void irParaFinalizado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaRecusado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Item item) {
        item.mudarEstadoPara(new ContraCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
