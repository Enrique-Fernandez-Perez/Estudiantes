package com.example.appBack.cabeceraFact.repositorio;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cliente.clase.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabeceraFactRepository extends JpaRepository<CabeceraFact,Integer > {
    List<CabeceraFact> findByCliente(Cliente cliente);
}
