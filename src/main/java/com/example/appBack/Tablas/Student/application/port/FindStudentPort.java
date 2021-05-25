package com.example.appBack.Tablas.Student.application.port;

import com.example.appBack.Tablas.Student.domain.Student;

import java.util.List;

public interface FindStudentPort {

    List<Student> getAll() throws Exception;


    Student getStudent(String id) throws Exception;
}
