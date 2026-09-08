package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public class EstadoFinalizado {

    public void irParaRascunho(Item item) {

        throw new IllegalStateException("Transição Inválida!");
    }

    public void irParaHomologacao(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaAtiva(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaNegociado(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public void irParaFinalizado(Item item) {

        throw new IllegalStateException("Já está como Finalizado. Transição inválida!");

    }

    public void irParaCancelado(Item item) {

        throw new IllegalStateException("Transição Inválida!");

    }

    public boolean isPodeMudar(){
        return false;
    }

}
