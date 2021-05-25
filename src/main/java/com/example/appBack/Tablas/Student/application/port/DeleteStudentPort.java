package com.example.appBack.Tablas.Student.application.port;

import com.example.appBack.Tablas.Student.domain.Student;

public interface DeleteStudentPort {
    Student delete(String id) throws Exception;
}
