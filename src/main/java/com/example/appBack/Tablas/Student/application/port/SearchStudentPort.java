package com.example.appBack.Tablas.Student.application.port;


import com.example.appBack.Tablas.Student.domain.Student;

import java.util.List;

public interface SearchStudentPort {
    List<Student> search(Student student);
}
