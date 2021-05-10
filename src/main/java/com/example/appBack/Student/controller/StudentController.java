package com.example.appBack.Student.controller;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    ServicioStudent servicioStudent;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO)
    {
        return servicioStudent.addStudent(studentDTO);
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudentById(@PathVariable String id){return servicioStudent.getStudent(id);}

    @GetMapping("/getStudents")
    public List<StudentDTO> getAllStudents(){
        return servicioStudent.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable String id){
        try {
            return servicioStudent.deleteStudent(id);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO)
    {
        try {
            return servicioStudent.updateStudent(id,studentDTO);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getStudent")
    public List<StudentDTO> getStudentConsulta(@RequestBody StudentDTO buscar)
    {
        try {
            return servicioStudent.getConsulaCampo(buscar);
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
