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
        ArrayList<String> col = servicioStudent.getColum(3,servicioStudent.getAllColums().size());

        List<StudentDTO> recogida = servicioStudent.getCompararValores(studentDTO,col);

        if(recogida==null){
            return ResponseEntity.ok("Fecha de baja superior a la de alta");
        }

        if(recogida.isEmpty()){
            servicioStudent.addStudent(studentDTO);
            return ResponseEntity.ok("Se ha insertado correctamente");
        }

        return ResponseEntity.ok("Error de creacion");

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
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO)
    {

        ArrayList<String> col = servicioStudent.getColum(id,3,servicioStudent.getAllColums().size());

        List<StudentDTO> recogida = servicioStudent.getCompararValores(studentDTO,col);

        if(recogida==null){
            return ResponseEntity.ok("Fecha de baja superior a la de alta o id no existente");
        }

        if(recogida.isEmpty()){
            servicioStudent.updateStudent(id,studentDTO);
            return ResponseEntity.ok("Se ha modificado correctamente");
    }

        return ResponseEntity.ok("Error de modificacion");
    }


    @GetMapping("/getStudent")
    public List<StudentDTO> getStudentConsulta(@RequestBody StudentDTO buscar){
    ArrayList<String> col =servicioStudent.getAllColums();

    List<StudentDTO> recogida = servicioStudent.getCompararValores(buscar,col);

    return recogida;
}

}
