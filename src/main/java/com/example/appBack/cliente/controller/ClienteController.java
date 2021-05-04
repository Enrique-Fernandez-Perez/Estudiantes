package com.example.appBack.cliente.controller;

import com.example.appBack.cliente.clase.Cliente;

import com.example.appBack.cliente.clase.ClienteFront;
import com.example.appBack.cliente.model.ClienteDB;
import com.example.appBack.cliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteDB clienteDB;

    @PostMapping
    public ClienteFront añadirCliente(@RequestBody ClienteFront c){
        try {
            clienteDB.guardarCliente(c);
            return c;
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping
    public List<Cliente> getAll(){
        return clienteDB.listaClientes();
    }

    @DeleteMapping("{id}")
    public boolean borrarClientePorId(@PathVariable int id){
        try {
            return clienteDB.borrarCliente(id);
        }catch (Exception e){
            return false;
        }
    }
   @PutMapping("{id}")
    public ClienteFront modificarPorID(@PathVariable int id, @RequestBody ClienteFront c){
        return clienteDB.actualizarCliente(id,c);
    }

}
