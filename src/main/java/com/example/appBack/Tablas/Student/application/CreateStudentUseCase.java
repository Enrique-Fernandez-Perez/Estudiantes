package com.example.appBack.Tablas.Student.application;

import com.example.appBack.Tablas.Student.application.port.CreateStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SaveCreateStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentUseCase implements CreateStudentPort {

    private SaveCreateStudentPort saveCreateStudentPort;

    @Override
    public Student create(Student student) throws Exception{
       return saveCreateStudentPort.addStudent(student);
    }
}
