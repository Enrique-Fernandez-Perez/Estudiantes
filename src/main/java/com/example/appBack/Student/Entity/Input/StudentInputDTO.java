package com.example.appBack.Student.Entity.Input;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {

    @NotNull
    private String nombre;

    @NotNull
    private String correo_trabajo;

    @NotNull
    private String correo_personal;

    @NotNull
    private String ciudad;

    @NotNull
    private int horas_semanales;

    @NotNull
    private String comentarios;

    //Añadir Branch

    @NotNull
    private boolean estado;

    @NotNull
    private Date fecha_creacion;

    private Date fecha_finalizacion;

}
