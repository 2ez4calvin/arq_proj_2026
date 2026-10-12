package com.trokr.model.state;

import com.trokr.model.StatusProposta;
import com.trokr.model.state.proposta.*;
import com.trokr.model.state.contraproposta.*;

public class EstadoFactory {

    public static EstadoProposta propostaDe(StatusProposta status){
        return switch (status){
            case RASCUNHO       -> new EstadoRascunho();
            case HOMOLOGACAO    -> new EstadoHomologacao();
            case ATIVA          -> new EstadoAtiva();
            case NEGOCIADO_RAIZ -> new EstadoNegociado();
            case FINALIZADO     -> new EstadoFinalizado();
            case CANCELADO_RAIZ -> new EstadoCancelado();
            default -> throw new IllegalArgumentException(
                "Status " + status + " não pertence a Proposta");
        };
    }

    public static EstadoContraproposta contraPropostaDe(StatusProposta status) {
        return switch (status) {
            case RASCUNHO          -> new ContraRascunho();
            case EM_ANALISE        -> new ContraAnalise();
            case NEGOCIADO_CONTRA  -> new ContraNegociado();
            case FINALIZADO_CONTRA -> new ContraFinalizado();
            case RECUSADO          -> new ContraRecusado();
            case CANCELADO_CONTRA  -> new ContraCancelado();
            default -> throw new IllegalArgumentException(
                "Status " + status + " não pertence a Contraproposta");
        };
    }
    
}
