package com.trokr.model.state;

import com.trokr.model.Item;

public interface EstadoItem {
    
    void avancar(Item item);

    void recuar(Item item);

    void cancelar(Item item);

}
