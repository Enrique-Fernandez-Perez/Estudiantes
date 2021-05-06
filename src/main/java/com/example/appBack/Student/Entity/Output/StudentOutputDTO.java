package com.example.appBack.Student.Entity.Output;

import com.sun.istack.NotNull;

import java.util.Date;

public class StudentOutputDTO {

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
    private Boolean estado;

    @NotNull
    private Date fecha_creacion;

    @NotNull
    private Date fecha_finalizacion;

}
