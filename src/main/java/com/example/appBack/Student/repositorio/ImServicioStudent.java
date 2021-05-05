package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import com.example.appBack.Student.repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ImServicioStudent implements ServicioStudent
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(StudentDTO sdto)
    {
        Student nuevoStudent = new Student(sdto);
        studentRepository.saveAndFlush(nuevoStudent);
    }

    @Override
    public StudentDTO getStudent(int id)
    {
        Optional<Student> estudiante = studentRepository.findById(id);
        if(!estudiante.isEmpty())
        {
            return StudentDTO.getDTO(estudiante.get());
        }

        return null;
    }

    @Override
    public List<StudentDTO> getAll()
    {
        List<Student> lista = studentRepository.findAll();
        if(lista.isEmpty())
        {
            return null;
        }
        else
        {
            return  StudentDTO.getAllDTO(lista);
        }
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void updateStudent(int id, StudentDTO sdto) {

    }

    @Override
    public List<StudentDTO> getConsulaCampo(StudentDTO aConsultar)
    {
        return studentRepository.getQuery(aConsultar);
    }
}
