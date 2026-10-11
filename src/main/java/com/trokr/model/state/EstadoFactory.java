package com.trokr.model.state;

import com.trokr.model.statusProposta;
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
            case RASCUNHO          -> new EstadoContraRascunho();
            case EM_ANALISE        -> new EstadoContraEmAnalise();
            case NEGOCIADO_CONTRA  -> new EstadoContraNegociado();
            case FINALIZADO_CONTRA -> new EstadoContraFinalizado();
            case RECUSADO          -> new EstadoContraRecusado();
            case CANCELADO_CONTRA  -> new EstadoContraCancelado();
            default -> throw new IllegalArgumentException(
                "Status " + status + " não pertence a Contraproposta");
        };
    }
    
}
