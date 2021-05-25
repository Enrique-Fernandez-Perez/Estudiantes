package com.example.appBack.Tablas.Student.infrastructure.repositorio;

import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SearchRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SearchStudentRepository implements SearchRepositoryStudentPort
{
    //@Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getConsultaCampo(Student aConsultar)
    {
        return Student.getAllDTO(studentRepository.getQueryLike(aConsultar));
    }
}
