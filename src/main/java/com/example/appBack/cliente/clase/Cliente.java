package com.example.appBack.cliente.clase;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(Integer id_cliente, String nombre) {
        this.idCliente = id_cliente;
        this.nombre = nombre;
    }
    public Cliente() {
    }
    public Cliente (ClienteFront cFront){
        this.nombre = cFront.getNombre();
    }
}
