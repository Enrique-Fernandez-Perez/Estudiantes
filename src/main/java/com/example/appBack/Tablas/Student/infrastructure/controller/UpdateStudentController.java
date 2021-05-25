package com.example.appBack.Tablas.Student.infrastructure.controller;

import com.example.appBack.Tablas.Student.application.port.UpdateStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.controller.dto.Input.StudentInputDTO;
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
public class UpdateStudentController {

    private UpdateStudentPort updateStudentPort;

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentInputDTO studentInputDTO) throws Exception
    {
        Student student = studentInputDTO.InputToDTO();
        student.setId(id);
        return updateStudentPort.update(student);
    }
}
