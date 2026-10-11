package com.trokr.model.state.contraproposta;

import com.trokr.model.Proposta;
import com.trokr.model.StatusProposta;

public interface EstadoContraproposta {

    void irParaRascunho(Proposta contraproposta);

    void irParaEmAnalise(Proposta contraproposta);

    void irParaNegociado(Proposta contraproposta);

    void irParaFinalizado(Proposta contraproposta);

    void irParaRecusado(Proposta contraproposta);

    void irParaCancelado(Proposta contraproposta);

    boolean isPodeMudar();

    StatusProposta getStatus();
}
