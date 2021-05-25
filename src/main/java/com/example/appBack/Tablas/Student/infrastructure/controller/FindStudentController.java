package com.example.appBack.Tablas.Student.infrastructure.controller;

import com.example.appBack.Tablas.Student.application.port.FindStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/estudiante")
@CrossOrigin("*")
@Api(tags= "estudiante")
@RestController
public class FindStudentController {

    private FindStudentPort findStudentPort;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) throws Exception
    {
        return findStudentPort.getStudent(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() throws Exception{
        return findStudentPort.getAll();
    }
}
