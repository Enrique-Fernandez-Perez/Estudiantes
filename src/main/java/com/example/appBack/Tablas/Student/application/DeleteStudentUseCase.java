package com.example.appBack.Tablas.Student.application;


import com.example.appBack.Tablas.Student.application.port.DeleteStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.DeleteRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteStudentUseCase implements DeleteStudentPort {

    private DeleteRepositoryStudentPort deleteRepositoryStudentPort;

    @Override
    public Student delete(String id) throws Exception{
        return deleteRepositoryStudentPort.deleteStudent(id);
    }
}
