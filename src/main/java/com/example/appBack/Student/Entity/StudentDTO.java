package com.example.appBack.Student.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO{

    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date fecha_entrada;

    private String ciudad;

    private Date horas_semanales;

    private String especialidad;

    private String estado;


    public StudentDTO(Student student){
        this.id=student.getId();
        this.nombre=student.getNombre();
        this.apellido=student.getApellido();
        this.correo=student.getCorreo();
        this.fecha_entrada=student.getFecha_entrada();
        this.ciudad=student.getCiudad();
        this.horas_semanales=student.getHoras_semanales();
        this.especialidad=student.getEspecialidad();
        this.estado=student.getEstado();
    }



}