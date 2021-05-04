package com.example.appBack.facturaInfo.clase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFactura {
    //string codigoProducto;
    String nombreProducto;
    int cantidadProducto;
    double precioProducto;
    double precioProductoFactura;
}
