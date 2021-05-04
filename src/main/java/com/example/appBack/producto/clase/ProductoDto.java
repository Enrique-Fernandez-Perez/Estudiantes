package com.example.appBack.producto.clase;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private String nombre;

    public ProductoDto(Producto producto) {
        this.nombre = producto.getNombre();
    }
}
