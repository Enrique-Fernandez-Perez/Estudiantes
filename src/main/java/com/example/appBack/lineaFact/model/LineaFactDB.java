package com.example.appBack.lineaFact.model;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.clase.CabeceraFactDTO;
import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.lineaFact.clase.LineaFact;
import com.example.appBack.lineaFact.clase.LineaFactDto;
import com.example.appBack.lineaFact.repositorio.LineaFactRepository;
import com.example.appBack.producto.clase.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LineaFactDB {
    @Autowired
    LineaFactRepository lineaFactDB;

    public LineaFactDto guardarLineaFact(LineaFactDto cb){
        LineaFact cabFac = new LineaFact(cb);
        try {
            lineaFactDB.save(cabFac);
            return cb;
        }catch (Exception e){
            return null;
        }
    }

    public boolean borrarPorId(int id) {
        try {
            lineaFactDB.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<LineaFact> listaLineaFact() {
        return lineaFactDB.findAll();
    }

    public LineaFactDto editarLineaFactPorID(int id, LineaFactDto c) {
        var lfop = lineaFactDB.findById(id);
        if(lfop.isPresent()){
            LineaFact lineaFact = lfop.get();
            if(c.getCabFact() != null)
                lineaFact.setCabFact(new CabeceraFact(c.getCabFact()));
            if(c.getCantidad() != 0)
                lineaFact.setCantidad(c.getCantidad());
            if(c.getPrecio() != 0.0)
                lineaFact.setPrecio(c.getPrecio());
            if(c.getProducto() != null)
                lineaFact.setProducto(new Producto(c.getProducto()));
            lineaFactDB.save(lineaFact);
            return c;
        }else{
            return null;
        }
    }
}
