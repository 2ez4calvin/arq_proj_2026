package com.trokr.model.state.Contraproposta;

import com.trokr.model.Item;

public class ContraRascunho implements EstadoContraproposta {

    @Override
    public void irParaRascunho(Item item) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaEmAnalise(Item item) {

        item.mudarEstadoPara(new ContraAnalise());

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
