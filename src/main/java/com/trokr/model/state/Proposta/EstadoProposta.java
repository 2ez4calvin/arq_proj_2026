package com.trokr.model.state.Proposta;

import com.trokr.model.Item;

public interface EstadoProposta {

    void irParaRascunho(Item item);

    void irParaHomologacao(Item item);

    void irParaAtiva(Item item);

    void irParaNegociado(Item item);

    void irParaFinalizado(Item item);

    void irParaCancelado(Item item);

    boolean isPodeMudar();
}
