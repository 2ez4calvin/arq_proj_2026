package com.trokr.model.state.proposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public interface EstadoProposta {

    void irParaRascunho(Proposta proposta);

    void irParaHomologacao(Proposta proposta);

    void irParaAtiva(Proposta proposta);

    void irParaNegociado(Proposta proposta);

    void irParaFinalizado(Proposta proposta);

    void irParaCancelado(Proposta proposta);

    boolean isPodeMudar();

    StatusProposta getStatus();
}
