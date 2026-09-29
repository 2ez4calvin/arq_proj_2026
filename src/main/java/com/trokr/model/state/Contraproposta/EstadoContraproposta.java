package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public interface EstadoContraproposta {

    void irParaRascunho(Proposta Proposta);

    void irParaEmAnalise(Proposta Proposta);

    void irParaNegociado(Proposta Proposta);

    void irParaFinalizado(Proposta Proposta);

    void irParaRecusado(Proposta Proposta);

    void irParaCancelado(Proposta Proposta);

    boolean isPodeMudar();
}
