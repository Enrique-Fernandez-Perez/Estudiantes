package com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA;

import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentJpa,String>
{
    List<StudentJpa> getQueryLike(Student consulta);

    List<StudentJpa> findByNombreAndApellido(String nombre, String apellido);

    List<StudentJpa> findByCorreo(String correo);
}
