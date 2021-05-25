package com.example.appBack.Tablas.Student.infrastructure.repositorio;

import com.example.appBack.Excepciones.UpdateErrorException;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.DeleteRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeleteStudentRepository implements DeleteRepositoryStudentPort
{
    StudentRepository studentRepository;

    @Override
    public Student deleteStudent(String id)
    {
        studentRepository.findById(id).orElseThrow(()-> new UpdateErrorException("Id no existente"));

        StudentJpa student = studentRepository.getOne(id);
        studentRepository.deleteById(id);
        return Student.getStudentDTO(student);
    }
}
