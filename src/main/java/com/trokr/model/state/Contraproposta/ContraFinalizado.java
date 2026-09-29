package com.trokr.model.state.Contraproposta;

public class ContraFinalizado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta Proposta) {

        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        throw new IllegalStateException("Já está como Finalizado. Transição inválida");
    }

    @Override
    public void irParaRecusado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public boolean isPodeMudar() {
        return false;
    }

}
