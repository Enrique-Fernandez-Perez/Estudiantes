package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicioStudent
{
    ResponseEntity addStudent(StudentDTO sdto);

    StudentDTO getStudent(int id);

    List<StudentDTO> getAll();

    ResponseEntity deleteStudent(int id);

    ResponseEntity updateStudent(int id, StudentDTO sdto);

    List<StudentDTO> getConsulaCampo(StudentDTO aConsultar);
}
