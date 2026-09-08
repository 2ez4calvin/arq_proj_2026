package com.trokr.model.state.Contraproposta;

import com.trokr.model.Item;

public interface EstadoContraproposta {

    void irParaRascunho(Item item);

    void irParaEmAnalise(Item item);

    void irParaNegociado(Item item);

    void irParaFinalizado(Item item);

    void irParaRecusado(Item item);

    void irParaCancelado(Item item);
}
