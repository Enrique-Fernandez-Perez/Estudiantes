package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ServicioStudent
{
    ResponseEntity addStudent(StudentDTO sdto);

    StudentDTO getStudent(String id);

    ResponseEntity deleteStudent(String id);

    ResponseEntity updateStudent(String id, StudentDTO sdto);

    List<StudentDTO> getConsultaCampo(StudentDTO aConsultar);

    List<StudentDTO> getAll();
}
