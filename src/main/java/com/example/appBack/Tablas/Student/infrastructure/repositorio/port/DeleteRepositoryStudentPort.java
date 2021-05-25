package com.example.appBack.Tablas.Student.infrastructure.repositorio.port;


import com.example.appBack.Tablas.Student.domain.Student;

public interface DeleteRepositoryStudentPort
{
    Student deleteStudent(String id) throws Exception;
}
