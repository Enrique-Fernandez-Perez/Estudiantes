package com.example.appBack.Tablas.Student.infrastructure.repositorio.port;


import com.example.appBack.Tablas.Student.domain.Student;

public interface SaveUpdateStudentPort {
    Student updateStudent(String id, Student sdto) throws Exception;
}
