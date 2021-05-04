package com.example.appBack.clienteFactura.model;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.repositorio.CabeceraFactRepository;
import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.cliente.repositorio.ClienteRepository;
import com.example.appBack.clienteFactura.clase.CabezaFactura;
import com.example.appBack.clienteFactura.clase.ClienteFact;
import com.example.appBack.facturaInfo.clase.ProductoFactura;
import com.example.appBack.lineaFact.clase.LineaFact;
import com.example.appBack.lineaFact.repositorio.LineaFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class ClienteFacturaDB {
    @Autowired
    ClienteRepository clientedb;

    @Autowired
    LineaFactRepository lineadb;

    @Autowired
    CabeceraFactRepository cabeceradb;

    /*public  List<LineaFact> obtenerFacturasPorIdCliente(int id) {
        List<LineaFact> facturas = new ArrayList<LineaFact>();
        List<CabeceraFact> cabeceras = cabeceradb.findByCliente(clientedb.findByIdCliente(id));
        cabeceras.forEach(cabecera ->
                //facturas.add(lineadb.findByCabFact(cabecera))
                        lineadb.findByCabFact(cabecera).forEach(a -> facturas.add(a))
                );
        return facturas;
    }
   /* public static List<LineaFact> obtenerFacturasPorID(int id, LineaFactRepository lineadb) {
        return lineadb.lineaFactPorIdCliente(id);
    }*/

    public ClienteFact obtenerFacturasPorIdCliente(int id){
       ClienteFact clienteDeVuelta = new ClienteFact();
       double precioTotalFactura = 0.0;
        var clienteOptional = clientedb.findById(id);
        if(clienteOptional.isPresent()){
           Cliente cliente = clienteOptional.get();
           clienteDeVuelta.setNombreCliente(cliente.getNombre()); // AÑADO EL NOMBRE
        }
        if(clienteOptional.isEmpty())
            return null;
        List<CabeceraFact> cabeceras = cabeceradb.findByCliente(clientedb.findByIdCliente(id));
        if(cabeceras != null){
            List<CabezaFactura> listaCabeceras = getCabFactFromCabecera(cabeceras);
            clienteDeVuelta.setCabezaFacturas(listaCabeceras); //AÑADO LAS CABECERAS
            for(CabezaFactura cf : listaCabeceras){
                precioTotalFactura = precioTotalFactura + cf.getImporteFactura();
            }
            clienteDeVuelta.setImporteTotalFacturas(precioTotalFactura); // AÑADIMOS EL PRECIO TOTAL
        }
        return clienteDeVuelta;
    }

    private List<CabezaFactura> getCabFactFromCabecera(List<CabeceraFact> cabeceras) {
        List<CabezaFactura> listaCabFac = new ArrayList<CabezaFactura>();
        for(CabeceraFact c : cabeceras){
            String numeroFactura = c.getNumeroFactura();
            Date fechaFactura = c.getFecha();
            double importeFactura = obtenerImporteTotalFromLineaDB(c);
            CabezaFactura cf = new CabezaFactura(numeroFactura,fechaFactura,importeFactura);
            listaCabFac.add(cf);
        }
        return listaCabFac;
    }

    private double obtenerImporteTotalFromLineaDB(CabeceraFact c) {
        List<LineaFact> lineaFacts = lineadb.findByCabFact(c);
        double precioTotal = 0.0;
        for(LineaFact lf : lineaFacts){
            precioTotal = precioTotal + lf.getPrecio();
        }
        return precioTotal;
    }


}
