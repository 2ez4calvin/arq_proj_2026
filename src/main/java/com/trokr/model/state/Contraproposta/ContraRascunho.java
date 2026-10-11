package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public class ContraRascunho implements EstadoContraproposta {

    @Override
    public void irParaRascunho(Proposta contraproposta) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaEmAnalise(Proposta contraproposta) {

        contraproposta.mudarEstadoPara(new ContraAnalise());

    }

    @Override
    public void irParaNegociado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaRecusado(Proposta contraproposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta contraproposta) {
        contraproposta.mudarEstadoPara(new ContraCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

}
