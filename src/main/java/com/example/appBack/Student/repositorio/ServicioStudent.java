package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.StudentDTO;

import java.util.HashMap;
import java.util.List;

public interface ServicioStudent
{
    void addStudent(StudentDTO sdto);

    StudentDTO getStudent(int id);

    List<StudentDTO> getAll();

    void deleteStudent(int id);

    void deleteStudent(StudentDTO sdto);

    void updateStudent(int id, StudentDTO sdto);

    List<StudentDTO> getConsulatCampo(StudentDTO aConsultar);
}
