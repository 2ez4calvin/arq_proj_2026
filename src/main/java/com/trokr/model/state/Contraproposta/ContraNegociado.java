package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;


public class ContraNegociado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta Proposta) {

        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Já está como Negociado. Transição inválida");
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new ContraFinalizado());
    }

    @Override
    public void irParaRecusado(Proposta Proposta) {
        Proposta.mudarEstadoPara(new ContraRecusado());
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}