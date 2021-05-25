package com.example.appBack.Tablas.Student.infrastructure.repositorio.port;

import com.example.appBack.Tablas.Student.domain.Student;

import java.util.List;

public interface SearchRepositoryStudentPort {
    List<Student> getConsultaCampo(Student aConsultar);
}
