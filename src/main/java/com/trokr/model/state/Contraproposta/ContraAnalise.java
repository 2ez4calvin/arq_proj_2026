package com.trokr.model.state.contraproposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public class ContraAnalise implements EstadoContraproposta{

    @Override
    public void irParaRascunho(Proposta contraproposta) {
        contraproposta.mudarEstadoPara(new ContraRascunho());
    }

    @Override
    public void irParaEmAnalise(Proposta contraproposta) {

        throw new IllegalStateException("Já está como Em análise. Transição inválida");
    }

    @Override
    public void irParaNegociado(Proposta contraproposta) {
        contraproposta.mudarEstadoPara(new ContraNegociado());
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

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.EM_ANALISE;
    }

}
