package com.example.appBack.Tablas.Student.infrastructure.controller;

import com.example.appBack.Tablas.Student.application.port.CreateStudentPort;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.controller.dto.Input.StudentInputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/estudiante")
@CrossOrigin("*")
@Api(tags= "estudiante")
@RestController
public class CreateStudentController {

    private CreateStudentPort createStudentPort;

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception
    {
        Student studentDTO = studentInputDTO.InputToDTO();
        Student student = createStudentPort.create(studentDTO);
        return student;
    }
}
