package com.example.appBack.Tablas.Student.infrastructure.controller;

import com.example.appBack.Tablas.Student.application.port.DeleteStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/estudiante")
@CrossOrigin("*")
@Api(tags= "estudiante")
@RestController
public class DeleteStudentController {

    private DeleteStudentPort deleteStudentPort;

    @DeleteMapping("/delete/{id}")
    public Student deleteStudentById(@PathVariable String id) throws Exception{
        Student student = deleteStudentPort.delete(id);
        return student;
    }
}
