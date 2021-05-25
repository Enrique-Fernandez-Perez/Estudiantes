package com.example.appBack.Tablas.Student.infrastructure.repositorio;

import com.example.appBack.Excepciones.NotFoundException;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.FindRepositoryStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FindStudentRepository implements FindRepositoryStudentPort
{
    StudentRepository studentRepository;

    @Override
    public Student getStudent(String id) throws Exception
    {
        Optional<StudentJpa> estudiante = studentRepository.findById(id);
        if(estudiante.isEmpty())
        {
            throw new NotFoundException("Estudiante inexistente");
        }

        return Student.getStudentDTO(estudiante.get());
    }

    @Override
    public List<Student> getAll() throws Exception
    {
        List<StudentJpa> lista = studentRepository.findAll();
        if(lista.isEmpty())
        {
            throw new NotFoundException("No existen estudiantes");
        }

        return Student.getAllDTO(lista);
    }
}
