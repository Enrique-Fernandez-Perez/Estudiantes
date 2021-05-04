package com.example.appBack.cabeceraFact.clase;

import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.cliente.clase.ClienteFront;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFactDTO {
    private String numeroFactura;
    ClienteFront cliente;
    Date fecha;

    public  CabeceraFactDTO(CabeceraFact cf){
        this.numeroFactura = cf.getNumeroFactura();
        this.fecha = cf.getFecha();
        this.cliente = new ClienteFront(cf.getCliente());
    }

}
