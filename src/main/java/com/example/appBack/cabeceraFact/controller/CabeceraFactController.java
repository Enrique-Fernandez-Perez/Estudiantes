package com.example.appBack.cabeceraFact.controller;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cabeceraFact.clase.CabeceraFactDTO;
import com.example.appBack.cabeceraFact.model.CabeceraFactDB;
import com.example.appBack.cabeceraFact.repositorio.CabeceraFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cfact")
@CrossOrigin("*")
public class CabeceraFactController {

    @Autowired
    CabeceraFactDB cabeceraDB;


    @PostMapping
    public CabeceraFactDTO añadirCabecFact(@RequestBody CabeceraFactDTO c){
        return cabeceraDB.guardarCabeceraFact(c);
    }

    @DeleteMapping("{id}")
    public boolean borrarPorId(@PathVariable int id){
       return cabeceraDB.borrarPorId(id);
    }
    @GetMapping
    public List<CabeceraFact> getAll(){
        return cabeceraDB.listaCabeceraFact();
    }
    @PutMapping("{id}")
    public CabeceraFactDTO modificarCabeceraFactPorID(@PathVariable int id, @RequestBody CabeceraFactDTO c){
        try{
            return cabeceraDB.editarCabeceraFactPorID(id,c);
        }catch (Exception e){
            return null;
        }
    }
}
