package com.example.appBack.lineaFact.controller;


import com.example.appBack.lineaFact.clase.LineaFact;
import com.example.appBack.lineaFact.clase.LineaFactDto;
import com.example.appBack.lineaFact.model.LineaFactDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linFact")
@CrossOrigin("*")
public class LineaFactController {
    @Autowired
    LineaFactDB lineaFactDB;



    @PostMapping
    public LineaFactDto añadirLineaFact(@RequestBody LineaFactDto c){
        try {
            lineaFactDB.guardarLineaFact(c);
            return c;
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping
    public List<LineaFact> getAll(){
        return lineaFactDB.listaLineaFact();
    }

    @DeleteMapping("{id}")
    public boolean borrarLineaFactPorId(@PathVariable int id){
        try {
            return lineaFactDB.borrarPorId(id);
        }catch (Exception e){
            return false;
        }
    }
    @PutMapping("{id}")
    public LineaFactDto modificarPorID(@PathVariable int id, @RequestBody LineaFactDto c){
       try{
         return lineaFactDB.editarLineaFactPorID(id,c);
       }catch (Exception e){
           return null;
       }
    }
}
