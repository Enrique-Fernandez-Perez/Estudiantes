package com.example.appBack.producto.clase;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @NotNull
    private String nombre;

    public Producto(Integer id_producto, String nombre) {
        this.id_producto = id_producto;
        this.nombre = nombre;
    }
    public Producto() {

    }
    public Producto(ProductoDto pdto) {
        this.nombre = pdto.getNombre();
    }

}
