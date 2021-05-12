package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicioStudent
{
    Student addStudent(StudentDTO sdto);

    StudentDTO getStudent(String id);

    StudentDTO deleteStudent(String id);

    Student updateStudent(String id, StudentDTO sdto);

    List<StudentDTO> getConsultaCampo(StudentDTO aConsultar);

    List<StudentDTO> getAll();
}
