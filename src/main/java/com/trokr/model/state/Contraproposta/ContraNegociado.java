package com.trokr.model.state.Contraproposta;

import com.trokr.model.Item;


public class ContraNegociado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Item item) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Item item) {

        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaNegociado(Item item) {
        throw new IllegalStateException("Já está como Negociado. Transição inválida");
    }

    @Override
    public void irParaFinalizado(Item item) {
        item.mudarEstadoPara(new ContraFinalizado());
    }

    @Override
    public void irParaRecusado(Item item) {
        item.mudarEstadoPara(new ContraRecusado());
    }

    @Override
    public void irParaCancelado(Item item) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}