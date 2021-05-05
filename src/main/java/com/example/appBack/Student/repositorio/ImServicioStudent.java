package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<StudentDTO> getAll() {
        return null;
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
