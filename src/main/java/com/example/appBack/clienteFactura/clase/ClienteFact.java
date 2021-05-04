package com.example.appBack.clienteFactura.clase;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteFact {
    String nombreCliente;
    double importeTotalFacturas;
    List<CabezaFactura> cabezaFacturas;
}
