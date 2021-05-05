package com.example.appBack.Student.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String nombre;
    private String apellido;
    private String correo;
    private Date fecha_entrada;
    private String ciudad;
    private Date horas_semanales;
    private String especialidad;
    private String estado;


}