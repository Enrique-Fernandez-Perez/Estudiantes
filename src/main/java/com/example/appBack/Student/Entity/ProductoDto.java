package com.example.appBack.Student.Entity;

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
