package com.example.appBack.facturaInfo.model;


import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.repositorio.CabeceraFactRepository;
import com.example.appBack.cliente.repositorio.ClienteRepository;

import com.example.appBack.facturaInfo.clase.FacturaCliente;
import com.example.appBack.facturaInfo.clase.ProductoFactura;
import com.example.appBack.lineaFact.clase.LineaFact;
import com.example.appBack.lineaFact.repositorio.LineaFactRepository;
import com.example.appBack.producto.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacturaInfoDB {

    @Autowired
    ClienteRepository clientedb;

    @Autowired
    LineaFactRepository lineadb;

    @Autowired
    CabeceraFactRepository cabeceradb;

    @Autowired
    ProductoRepository productodb;


    public FacturaCliente getFacturaForID(int id) {
        FacturaCliente facturaDeVuelta = null;
        CabeceraFact cb = new CabeceraFact();
        var cabeceraOp = cabeceradb.findById(id);
        if(cabeceraOp.isEmpty()){
            System.out.println("VACIO");
            return null;
        }
        if(cabeceraOp.isPresent()){
            facturaDeVuelta = new FacturaCliente();
             cb = cabeceraOp.get();
            facturaDeVuelta.setFechaFactura(cb.getFecha());
            facturaDeVuelta.setNumeroFactura(cb.getNumeroFactura());
            facturaDeVuelta.setNombreCliente(cb.getCliente().getNombre());
        }
        List<LineaFact> listaLineasFact = lineadb.findByCabFact(cb);
        List<ProductoFactura> facturaProductos = getListProductsFromLineaFact(listaLineasFact);
        facturaDeVuelta.setLineaFactura(facturaProductos);
        double precioTotal = 0.0;
        if(!facturaProductos.isEmpty()){
            for(ProductoFactura pf : facturaProductos){
                precioTotal = precioTotal + pf.getPrecioProductoFactura();
            }
            facturaDeVuelta.setImporteTotalFactura(precioTotal);
        }
        return facturaDeVuelta;
    }

    private List<ProductoFactura> getListProductsFromLineaFact(List<LineaFact> listaLineasFact) {
        List<ProductoFactura> productosFacturas = new ArrayList<ProductoFactura>();
        for(LineaFact lf : listaLineasFact){
            System.out.println("ENTRA ARRAY");
            int cantidad = lf.getCantidad();
            double precioProduto = lf.getPrecio();
            double precioProductoTotal = cantidad * precioProduto;
            productosFacturas.add(new ProductoFactura(lf.getProducto().getNombre(),cantidad,precioProduto,precioProductoTotal));
        }
        return productosFacturas;
    }

    /*String nombreProducto;
    int cantidadProducto;
    double precioProducto;
    double precioProductoFactura;*/
}
