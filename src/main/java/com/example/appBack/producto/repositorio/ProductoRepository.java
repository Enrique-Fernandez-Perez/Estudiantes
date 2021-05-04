package com.example.appBack.producto.repositorio;

import com.example.appBack.producto.clase.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
