package com.trokr.model.state.contraproposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;


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

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.NEGOCIADO_CONTRA;
    }

}