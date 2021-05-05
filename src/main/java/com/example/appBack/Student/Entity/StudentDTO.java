package com.example.appBack.Student.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO{

    private String nombre;

    private String apellido;

    private String correo;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date fecha_entrada;

    private String ciudad;

    private Date horas_semanales;

    private String especialidad;

    private String estado;


    public static StudentDTO getDTO(Student student){
        return new StudentDTO(student.getNombre(),
                student.getApellido(),
                student.getCorreo(),
                student.getFecha_entrada(),
                student.getCiudad(),
                student.getHoras_semanales(),
                student.getEspecialidad(),
                student.getEstado());
    }

    public static List<StudentDTO> getAllDTO(List<Student> listStudent){
        List<StudentDTO> devolver = new ArrayList<>();
        listStudent.stream().map(student -> devolver.add(getDTO(student)));
        return devolver;
    }



}