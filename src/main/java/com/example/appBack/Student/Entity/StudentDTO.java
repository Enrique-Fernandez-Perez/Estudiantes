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

    private Integer horas_semanales;

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


    public static HashMap<String,String> devolverNull(StudentDTO student){
        HashMap<String,String> listaNull = new HashMap<>();

        if(student.getNombre().trim().length()!=0){listaNull.put("nombre", student.getNombre());}
        if(student.getApellido().trim().length()!=0){listaNull.put("apellido", student.getApellido());}
        if(student.getCorreo().trim().length()!=0){listaNull.put("correo", student.getCorreo());}
        if(student.getFecha_entrada().toString().trim().length()!=0){listaNull.put("fecha_entrada", student.getApellido().toString());}
        if(student.getCiudad().trim().length()!=0){listaNull.put("ciudad", student.getCiudad());}
        if(student.getHoras_semanales()!=null){listaNull.put("horas_semanales", student.getHoras_semanales().toString());}
        if(student.getEspecialidad().trim().length()!=0){listaNull.put("especialidad", student.getEspecialidad());}
        if(student.getEstado().trim().length()!=0){listaNull.put("estado", student.getEstado());}

        return listaNull;

    }


}