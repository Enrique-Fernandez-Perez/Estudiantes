package com.example.appBack.Student.controller;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.example.appBack.Student.repositorio.ServicioStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    ServicioStudent servicioStudent;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO)
    {
        try {
            Student student = servicioStudent.addStudent(studentDTO);
            return ResponseEntity.ok(student);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
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
            StudentDTO student = servicioStudent.deleteStudent(id);
            return ResponseEntity.ok(student);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO)
    {
        try {
        Student student = servicioStudent.updateStudent(id,studentDTO);
        return ResponseEntity.ok(student);
            }catch(Exception e){
        return ResponseEntity.badRequest().body(e);
    }
    }

    @GetMapping("/getStudent")
    public List<StudentDTO> getStudentConsulta(@RequestBody StudentDTO buscarStudentbyStudentDTO)
    {
        try {
            List<StudentDTO> lista = servicioStudent.getConsultaCampo(buscarStudentbyStudentDTO);
            return lista;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
