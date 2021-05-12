package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String>
{

    List<StudentDTO> getQueryEquals(StudentDTO consulta);

    List<StudentDTO> getQueryLike(StudentDTO consulta);

    @Query("Select U FROM Student where nombre = :nombre and apellido = :apellido")
    List<Student> findByNombreAndApellido(String nombre, String apellido);

    @Query("Select U FROM Student where correo = :correo")
    List<Student> findByCorreo(String correo);
}
