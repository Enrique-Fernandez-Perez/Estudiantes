package com.example.appBack.Student.controller;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import org.springframework.beans.factory.annotation.Autowired;
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
        //servicioStudent.addStudent(studentDTO);
        Optional<StudentDTO> estudiante = Optional.of(studentDTO);
        ArrayList<String> col = servicioStudent.getAllColums();
        Student poner = servicioStudent.getCompararValores(estudiante,col);
        if(poner == null)
        {
            servicioStudent.addStudent(studentDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok("Error de creacion, estudiante existente o valores nulos no aceptable");
        //return ResponseEntity.ok().build();
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudentById(@PathVariable String id){return servicioStudent.getStudent(id);}

    @GetMapping("/getStudents")
    public List<StudentDTO> getAllStudents(){
        return servicioStudent.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable String id){
        servicioStudent.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO){
        servicioStudent.updateStudent(id,studentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getStudent")
    public List<StudentDTO> getStudentConsulta(@RequestBody StudentDTO buscar)
    {
        return servicioStudent.getConsulaCampo(buscar);
    }

}
