package com.example.appBack.cliente.repositorio;

import com.example.appBack.cliente.clase.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
     Cliente findByIdCliente(Integer id);
}
