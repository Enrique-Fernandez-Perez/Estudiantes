package com.example.appBack.Tablas.Student.infrastructure.repositorio.port;

import com.example.appBack.Tablas.Student.domain.Student;

import java.util.List;

public interface FindRepositoryStudentPort {
    Student getStudent(String id) throws Exception;

    List<Student> getAll() throws Exception;
}
