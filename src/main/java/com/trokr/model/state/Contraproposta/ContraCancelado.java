package com.trokr.model.state.Contraproposta;

import com.trokr.model.Item;

public class ContraCancelado implements EstadoContraproposta {

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
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaFinalizado(Item item) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaRecusado(Item item) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaCancelado(Item item) {
        throw new IllegalStateException("Já está como Cancelado. Transição inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

}
