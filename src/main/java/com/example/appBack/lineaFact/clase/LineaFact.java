package com.example.appBack.lineaFact.clase;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.producto.clase.Producto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class LineaFact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_linFact;

    @ManyToOne
    @JoinColumn(name = "id_cabFact")
    CabeceraFact cabFact;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    Producto producto;

    private int cantidad;
    private double precio;

    public LineaFact(Integer id_linFact, CabeceraFact cab_fact, int cantidad, double precio,Producto producto) {
        this.id_linFact = id_linFact;
        this.cabFact = cab_fact;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
    }

    public LineaFact() {
    }

    public LineaFact(LineaFactDto lfd){
        this.cabFact = new CabeceraFact(lfd.getCabFact());
        this.cantidad = lfd.getCantidad();
        this.precio = lfd.getPrecio();
        this.producto = new Producto(lfd.getProducto());
    }
}
