package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ImServicioStudent implements ServicioStudent
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity addStudent(StudentDTO sdto)
    {
        Student nuevoStudent = new Student(sdto);
        studentRepository.saveAndFlush(nuevoStudent);

        return ResponseEntity.ok().build();
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
    public ResponseEntity deleteStudent(int id) {
        ResponseEntity respuesta=null;
        if(studentRepository.existsById(id)==true){
           studentRepository.deleteById(id);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity updateStudent(int id, StudentDTO sdto) {
        if(studentRepository.existsById(id)==true){
            Student student = studentRepository.findById(id).get();
            student.setNombre(sdto.getNombre());
            student.setApellido(sdto.getApellido());
            student.setCorreo(sdto.getCorreo());
            student.setFecha_entrada(sdto.getFecha_entrada());
            student.setCiudad(sdto.getCiudad());
            student.setHoras_semanales(sdto.getHoras_semanales());
            student.setEspecialidad(sdto.getEspecialidad());
            student.setEstado(sdto.getEstado());

            studentRepository.saveAndFlush(student);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<StudentDTO> getConsulaCampo(StudentDTO aConsultar)
    {
        return studentRepository.getQuery(aConsultar);
    }
}
