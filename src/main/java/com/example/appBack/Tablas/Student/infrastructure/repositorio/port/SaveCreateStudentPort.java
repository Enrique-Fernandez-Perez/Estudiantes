package com.example.appBack.Tablas.Student.infrastructure.repositorio.port;


import com.example.appBack.Tablas.Student.domain.Student;

public interface SaveCreateStudentPort {
    Student addStudent(Student studentDto) throws Exception;
}
