package com.example.appBack.cliente.model;

import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.cliente.clase.ClienteFront;
import com.example.appBack.cliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteDB {
    @Autowired
    ClienteRepository clienteDB ;

    public ClienteFront guardarCliente(ClienteFront cFront){
        Cliente cliente = new Cliente(cFront);
        try {
            clienteDB.save(cliente);
            return cFront;
        }catch (Exception e){
            return null;
        }
    }

    public boolean borrarCliente(int id){
        try{
            clienteDB.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ClienteFront actualizarCliente(int id, ClienteFront c) {
        var cliente = clienteDB.findById(id);

        if(cliente.isEmpty())
            return null;
        else {
            Cliente clienteEditar = cliente.get();
            clienteEditar.setNombre(c.getNombre());
            clienteDB.save(clienteEditar);
            return c;
        }
    }
    public List<Cliente> listaClientes(){
        return clienteDB.findAll();
    }
}
