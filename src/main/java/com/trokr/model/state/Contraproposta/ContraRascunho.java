package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public class ContraRascunho implements EstadoContraproposta {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta Proposta) {

        Proposta.mudarEstadoPara(new ContraAnalise());

    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
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
