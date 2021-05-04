package com.example.appBack.cabeceraFact.model;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.clase.CabeceraFactDTO;
import com.example.appBack.cabeceraFact.repositorio.CabeceraFactRepository;
import com.example.appBack.cliente.clase.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CabeceraFactDB {
    @Autowired
    CabeceraFactRepository cabeceraDB;

    public CabeceraFactDTO guardarCabeceraFact(CabeceraFactDTO cb){
        CabeceraFact cabFac = new CabeceraFact(cb);
        try {
            cabeceraDB.save(cabFac);
            return cb;
        }catch (Exception e){
            return null;
        }

    }

    public boolean borrarPorId(int id) {
        try {
            cabeceraDB.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<CabeceraFact> listaCabeceraFact() {
        return cabeceraDB.findAll();
    }

    public CabeceraFactDTO editarCabeceraFactPorID(int id, CabeceraFactDTO c) {
        var cabFactOp = cabeceraDB.findById(id);
        if(cabFactOp.isPresent()){
            CabeceraFact cabFact = cabFactOp.get();
            cabFact.setNumeroFactura(c.getNumeroFactura());
            cabFact.setCliente(new Cliente(c.getCliente()));
            cabFact.setFecha(c.getFecha());
            cabeceraDB.save(cabFact);
            return c;
        }else{
            return null;
        }
    }
}
