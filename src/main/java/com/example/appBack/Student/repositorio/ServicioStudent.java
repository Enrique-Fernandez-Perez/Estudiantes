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

    List<StudentDTO> getAll();

    ResponseEntity deleteStudent(String id);

    ResponseEntity updateStudent(String id, StudentDTO sdto);

    List<StudentDTO> getConsulaCampo(StudentDTO aConsultar);

    List<StudentDTO> getCompararValores(StudentDTO insertado, ArrayList<String> columnas);

    ArrayList<String> getAllColums();

    ArrayList<String> getAllColums(String id);

    ArrayList<String> getColum(Integer numCampos, Integer posicionPrimerCampo);

    ArrayList<String> getColum(String id, Integer numCampos, Integer posicionPrimerCampo);
}
