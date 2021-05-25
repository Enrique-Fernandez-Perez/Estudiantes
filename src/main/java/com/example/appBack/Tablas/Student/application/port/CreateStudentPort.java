package com.example.appBack.Tablas.Student.application.port;


import com.example.appBack.Tablas.Student.domain.Student;

public interface CreateStudentPort {
    Student create(Student student) throws Exception;
}
