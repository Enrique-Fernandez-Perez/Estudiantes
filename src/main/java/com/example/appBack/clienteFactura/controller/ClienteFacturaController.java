package com.example.appBack.clienteFactura.controller;


import com.example.appBack.clienteFactura.clase.ClienteFact;

import com.example.appBack.clienteFactura.model.ClienteFacturaDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin("*")
public class ClienteFacturaController {
    @Autowired
    ClienteFacturaDB clienteFacturaDB;

    @GetMapping("{id}")
    public ClienteFact buscarPorId(@PathVariable int id){
        return clienteFacturaDB.obtenerFacturasPorIdCliente(id);
    }
}
