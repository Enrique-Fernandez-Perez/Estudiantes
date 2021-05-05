package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
