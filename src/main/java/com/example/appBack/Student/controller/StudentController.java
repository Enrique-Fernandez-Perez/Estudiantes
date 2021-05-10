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
        try {
            return servicioStudent.addStudent(studentDTO);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
        /*try {
            return servicioStudent.validar(studentDTO,"ADD","");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }

        /**try
        {
            //servicioStudent.addStudent(studentDTO);
            ArrayList<String> col = servicioStudent.getColum(3, servicioStudent.getAllColums().size());


            List<StudentDTO> recogida = new ArrayList<>();
            try{
                recogida = servicioStudent.getCompararValores(studentDTO, col);
                if (recogida == null){
                    return ResponseEntity.ok("Fecha de baja superior a la de alta");
                }
            }
            catch (Exception e){
                return ResponseEntity.ok("Fecha de baja superior a la de alta");
            }


            if (recogida.isEmpty()) {
                servicioStudent.addStudent(studentDTO);
                return ResponseEntity.ok("Se ha insertado correctamente");
            }


            /**if (recogida == null)
            {
                return ResponseEntity.ok("Fecha de baja superior a la de alta");
            }///

            return ResponseEntity.ok("Error de creacion");
        }catch (Exception e){
            return ResponseEntity.ok("Error de creacion por valores nulos");
        }*/
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
        /*try{
            servicioStudent.deleteStudent(id);
            ArrayList<String> col =servicioStudent.getColum(id, 0,servicioStudent.getAllColums().size());

            List<StudentDTO> recogida = servicioStudent.getCompararValores(new StudentDTO(),col);

            if(recogida==null){
                return ResponseEntity.ok("ERROR 401");
            }

            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.ok("Error de creacion por valores nulos");
        }*/
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
        /**try{
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
         }catch (Exception e){
           return ResponseEntity.ok("Error de creacion por valores nulos");
        }*/
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
        /*try{
            ArrayList<String> col =servicioStudent.getAllColums();

            List<StudentDTO> recogida = servicioStudent.getCompararValores(buscar,col);

            return recogida;
        }catch (Exception e){
            return null;
        }*/
    }

}
