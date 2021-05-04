package com.example.appBack.clienteFactura.clase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabezaFactura {
    String numFactura;
    Date fechaFactura;
    double importeFactura;
}
