package com.example.appBack.producto.model;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.clase.CabeceraFactDTO;
import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.producto.clase.Producto;
import com.example.appBack.producto.clase.ProductoDto;
import com.example.appBack.producto.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDB {

    @Autowired
    ProductoRepository productodb;

    public ProductoDto guardarProducto(ProductoDto cb){
        Producto cabFac = new Producto(cb);
        try {
            productodb.save(cabFac);
            return cb;
        }catch (Exception e){
            return null;
        }

    }

    public boolean borrarPorId(int id) {
        try {
            productodb.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Producto> listaProducto() {
        return productodb.findAll();
    }

    public ProductoDto editarProductoPorID(int id, ProductoDto c) {
        var productoOp = productodb.findById(id);
        if(productoOp.isPresent()){
            Producto producto = productoOp.get();
            producto.setNombre(c.getNombre());
            productodb.save(producto);
            return c;
        }else{
            return null;
        }
    }
}
