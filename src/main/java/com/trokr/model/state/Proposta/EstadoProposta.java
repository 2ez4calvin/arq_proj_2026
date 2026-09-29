package com.trokr.model.state.Proposta;

import com.trokr.model.Proposta;

public interface EstadoProposta {

    void irParaRascunho(Proposta Proposta);

    void irParaHomologacao(Proposta Proposta);

    void irParaAtiva(Proposta Proposta);

    void irParaNegociado(Proposta Proposta);

    void irParaFinalizado(Proposta Proposta);

    void irParaCancelado(Proposta Proposta);

    boolean isPodeMudar();
}
