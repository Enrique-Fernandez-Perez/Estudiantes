package com.example.appBack.cabeceraFact.clase;

import com.example.appBack.cliente.clase.Cliente;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class CabeceraFact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_CabFact;

    @NotNull
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    Cliente cliente;


    Date fecha;

    public CabeceraFact(Integer id_CabFact, String numeroFactura, Cliente cliente, Date fecha) {
        this.id_CabFact = id_CabFact;
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public CabeceraFact() {
    }

    public CabeceraFact(CabeceraFactDTO cff){
        this.numeroFactura = cff.getNumeroFactura();
        this.cliente = new Cliente(cff.cliente);
        this.fecha = cff.getFecha();
    }

}
