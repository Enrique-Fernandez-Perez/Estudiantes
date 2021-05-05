package com.example.appBack.Student.controller;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.persistence.PostRemove;

@RestController
public class StudentController {

    @Autowired
    ServicioStudent servicioStudent;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO){
        servicioStudent.addStudent(studentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudentById(@PathVariable int id){
        return servicioStudent.getStudent(id);
    }

    @GetMapping("/getStudents")
    public List<StudentDTO> getAllStudents(){
        return servicioStudent.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable int id){
        servicioStudent.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestBody StudentDTO studentDTO){
        servicioStudent.deleteStudent(studentDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@RequestBody StudentDTO studentDTO){
        servicioStudent.updateStudent(id,studentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getStudent/{campo}")
    public StudentDTO getStudentConsulta(@RequestBody StudentDTO buscar)
    {


        return null;
        //return servicioStudent.getConsulatCampo(campo,buscar);
    }

}
