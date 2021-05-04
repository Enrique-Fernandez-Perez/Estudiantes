package com.example.appBack.facturaInfo.controller;

import com.example.appBack.facturaInfo.clase.FacturaCliente;
import com.example.appBack.facturaInfo.model.FacturaInfoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("factura")
@CrossOrigin("*")
public class FacturaInfoController {
    @Autowired
    FacturaInfoDB facturaInfoDB;

    @GetMapping("{id}")
    public FacturaCliente buscarFacturaPorId(@PathVariable int id) {
        System.out.println("ENTRA");
        return facturaInfoDB.getFacturaForID(id);

    }

}
