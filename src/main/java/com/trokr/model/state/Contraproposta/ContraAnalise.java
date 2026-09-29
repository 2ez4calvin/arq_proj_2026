package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public class ContraAnalise implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta Proposta) {
        Proposta.mudarEstadoPara(new ContraRascunho());
    }

    @Override
    public void irParaEmAnalise(Proposta Proposta) {

        throw new IllegalStateException("Já está como Em análise. Transição inválida");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new ContraNegociado());
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaRecusado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new ContraCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
