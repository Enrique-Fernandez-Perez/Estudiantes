package com.example.appBack.cliente.clase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteFront {
    String nombre;

    public ClienteFront(Cliente c){
        this.nombre = c.getNombre();
    }
}
