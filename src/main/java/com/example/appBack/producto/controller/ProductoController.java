package com.example.appBack.producto.controller;

import com.example.appBack.producto.clase.Producto;
import com.example.appBack.producto.clase.ProductoDto;
import com.example.appBack.producto.model.ProductDB;
import com.example.appBack.producto.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    ProductDB productoDB;

    @PostMapping
    public ProductoDto añadirProducto(@RequestBody ProductoDto c){
        try {
            productoDB.guardarProducto(c);
            return c;
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping
    public List<Producto> getAll(){
        return productoDB.listaProducto();
    }

    @DeleteMapping("{id}")
    public boolean borrarClientePorId(@PathVariable int id){
        try {
            return productoDB.borrarPorId(id);
        }catch (Exception e){
            return false;
        }
    }
    @PutMapping("{id}")
    public ProductoDto modificarPorID(@PathVariable int id, @RequestBody ProductoDto c){
      try{
          return productoDB.editarProductoPorID(id,c);
      }catch (Exception e){
        return null;
      }

    }
}
