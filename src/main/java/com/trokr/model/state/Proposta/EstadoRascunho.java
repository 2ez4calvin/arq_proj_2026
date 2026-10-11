package com.trokr.model.state.proposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public class EstadoRascunho implements EstadoProposta {

    @Override
    public void irParaRascunho(Proposta proposta) {
        throw new IllegalStateException("Já está como rascunho. Transição inválida");
    }

    @Override
    public void irParaHomologacao(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoHomologacao());
    }

    @Override
    public void irParaAtiva(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaCancelado(Proposta proposta) {
        proposta.mudarEstadoPara(new EstadoCancelado());
    }

    @Override
    public boolean isPodeMudar() {
        return true;
    }

    @Override
    public StatusProposta getStatus() {
        return StatusProposta.RASCUNHO;
    }
}
