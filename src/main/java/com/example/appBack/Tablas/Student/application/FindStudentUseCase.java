package com.example.appBack.Tablas.Student.application;

import com.example.appBack.Tablas.Student.application.port.FindStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.FindRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FindStudentUseCase implements FindStudentPort {

    private FindRepositoryStudentPort findRepositoryStudentPort;

    @Override
    public List<Student> getAll() throws Exception {
        return findRepositoryStudentPort.getAll();
    }

    @Override
    public Student getStudent(String id) throws Exception {
        return findRepositoryStudentPort.getStudent(id);
    }
}
