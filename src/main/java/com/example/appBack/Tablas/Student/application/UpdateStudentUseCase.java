package com.example.appBack.Tablas.Student.application;

import com.example.appBack.Tablas.Student.application.port.UpdateStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SaveUpdateStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateStudentUseCase implements UpdateStudentPort {

    private SaveUpdateStudentPort saveUpdateStudentPort;

    @Override
    public Student update(Student student) throws Exception {
        return saveUpdateStudentPort.updateStudent(student.getId(), student);
    }
}
