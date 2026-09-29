package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public class EstadoFinalizado {

    @Override
    public void irParaRascunho(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaHomologacao(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaAtiva(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaNegociado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public void irParaFinalizado(Proposta Proposta) {
        throw new IllegalStateException("Já está como Finalizado. Transição inválida!");
    }

    @Override
    public void irParaCancelado(Proposta Proposta) {
        throw new IllegalStateException("Transição Inválida!");
    }

    @Override
    public boolean isPodeMudar(){
        return false;
    }

}
