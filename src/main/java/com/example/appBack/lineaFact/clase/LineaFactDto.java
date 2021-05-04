package com.example.appBack.lineaFact.clase;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.clase.CabeceraFactDTO;
import com.example.appBack.lineaFact.model.LineaFactDB;
import com.example.appBack.producto.clase.Producto;
import com.example.appBack.producto.clase.ProductoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFactDto {
    CabeceraFactDTO cabFact;
    ProductoDto producto;
    private int cantidad;
    private double precio;

    public LineaFactDto(LineaFact lf){
        this.cabFact = new CabeceraFactDTO(lf.getCabFact());
        this.cantidad = lf.getCantidad();
        this.precio = lf.getPrecio();
        this.producto = new ProductoDto(lf.getProducto());
    }


}
