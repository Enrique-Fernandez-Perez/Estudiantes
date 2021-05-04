package com.example.appBack.facturaInfo.clase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCliente {
    String numeroFactura;
    String nombreCliente;
    Date fechaFactura;
    double importeTotalFactura;

    List<ProductoFactura> lineaFactura;
}
