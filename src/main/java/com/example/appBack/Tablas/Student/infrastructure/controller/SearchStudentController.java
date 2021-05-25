package com.example.appBack.Tablas.Student.infrastructure.controller;

import com.example.appBack.Tablas.Student.application.port.SearchStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.controller.dto.Output.StudentSearchDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/estudiante")
@CrossOrigin("*")
@Api(tags= "estudiante")
@RestController
public class SearchStudentController {

    private SearchStudentPort searchStudentPort;

    @GetMapping
    public List<Student> getStudentConsulta(@RequestBody StudentSearchDTO studentSearchDTO)
    {
        Student student = studentSearchDTO.convertStudent();
        return searchStudentPort.search(student);
    }
}
