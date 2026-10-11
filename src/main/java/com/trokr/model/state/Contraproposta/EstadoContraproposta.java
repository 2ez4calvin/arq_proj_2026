package com.trokr.model.state.Contraproposta;

import com.trokr.model.Proposta;

public interface EstadoContraproposta {

    void irParaRascunho(Proposta contraproposta);

    void irParaEmAnalise(Proposta contraproposta);

    void irParaNegociado(Proposta contraproposta);

    void irParaFinalizado(Proposta contraproposta);

    void irParaRecusado(Proposta contraproposta);

    void irParaCancelado(Proposta contraproposta);

    boolean isPodeMudar();
}
