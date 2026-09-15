package com.trokr.model.state.Contraproposta;

public class ContraFinalizado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Item item) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Item item) {

        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Item item) {
        throw new IllegalStateException("Já está como Finalizado. Transição inválida");
    }

    @Override
    public void irParaRecusado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Item item) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

}
