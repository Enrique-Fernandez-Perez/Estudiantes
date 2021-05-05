package com.example.appBack.Student.model;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import com.example.appBack.Student.repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
            return new StudentDTO(estudiante.get());
        }

        return null;
    }

    @Override
    public List<StudentDTO> getAll()
    {
        List<Student> lista = studentRepository.findAll();
        List<StudentDTO> devolver = new ArrayList<>();
        lista.forEach(s -> devolver.add(new StudentDTO(s)));
        return devolver;
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void deleteStudent(StudentDTO sdto) {

    }

    @Override
    public void updateStudent(int id, StudentDTO sdto) {

    }

    @Override
    public StudentDTO getConsulatCampo(String campo, String busca)
    {
        return null;
    }
}
