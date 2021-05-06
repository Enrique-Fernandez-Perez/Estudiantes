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

    StudentDTO getStudent(int id);

    List<StudentDTO> getAll();

    ResponseEntity deleteStudent(int id);

    ResponseEntity updateStudent(int id, StudentDTO sdto);

    List<StudentDTO> getConsulaCampo(StudentDTO aConsultar);

    Student getCompararValores(Optional<StudentDTO> insertado, ArrayList<String> columnas);

    ArrayList<String> getAllColums();

    ArrayList<String> getAllColums(String id);

    ArrayList<String> getColum(String numCampos, String posicionPrimerCampo);

    ArrayList<String> getColum(String id, String numCampos, String posicionPrimerCampo);
}
