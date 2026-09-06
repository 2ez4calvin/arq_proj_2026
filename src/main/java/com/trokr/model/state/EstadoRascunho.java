package com.trokr.model.state;

import com.trokr.model.Item;

public class EstadoRascunho implements EstadoItem{

    public void avancar(Item item){

        item.mudarEstadoPara(new EstadoHomologacao())
    }

    public void recuar(Item item){

        throw new IllegalStateException("Já está no início");

    }
    
    public void cancelar(Item item){



    }

}
