package com.example.appBack.Tablas.Student.application;

import com.example.appBack.Tablas.Student.application.port.SearchStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SearchRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SearchStudentUseCase implements SearchStudentPort {

    private SearchRepositoryStudentPort searchRepositoryStudentPort;

    @Override
    public List<Student> search(Student student) {
        return searchRepositoryStudentPort.getConsultaCampo(student);
    }
}
