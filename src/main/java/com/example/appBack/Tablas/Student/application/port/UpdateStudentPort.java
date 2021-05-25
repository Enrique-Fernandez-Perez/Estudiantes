package com.example.appBack.Tablas.Student.application.port;


import com.example.appBack.Tablas.Student.domain.Student;

public interface UpdateStudentPort {
    Student update(Student student) throws Exception;
}
