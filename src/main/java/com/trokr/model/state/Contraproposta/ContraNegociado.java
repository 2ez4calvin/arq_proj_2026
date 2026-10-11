package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;


public class ContraNegociado implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta contraproposta) {

        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public void irParaNegociado(Proposta contraproposta) {
        throw new IllegalStateException("Já está como Negociado. Transição inválida");
    }

    @Override
    public void irParaFinalizado(Proposta contraproposta) {
        contraproposta.mudarEstadoPara(new ContraFinalizado());
    }

    @Override
    public void irParaRecusado(Proposta contraproposta) {
        contraproposta.mudarEstadoPara(new ContraRecusado());
    }

    @Override
    public void irParaCancelado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida");
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}