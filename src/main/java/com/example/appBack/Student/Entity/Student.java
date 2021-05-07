package com.example.appBack.Student.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String correo;

    @NotNull
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date fecha_entrada;

    @NotNull
    private String ciudad;

    @NotNull
    private Integer horas_semanales;

    @NotNull
    private String especialidad;

    @NotNull
    private String estado;

    @NotNull
    private String correo_trabajo;

    @NotNull
    private String comentarios;

    //Branch branch

    @NotNull
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date fecha_finalizacion;


    public Student(StudentDTO studentDTO){
        //id null
        this.nombre=studentDTO.getNombre();
        this.apellido=studentDTO.getApellido();
        this.correo=studentDTO.getCorreo();
        this.fecha_entrada=studentDTO.getFecha_entrada();
        this.ciudad=studentDTO.getCiudad();
        this.horas_semanales=studentDTO.getHoras_semanales();
        this.especialidad=studentDTO.getEspecialidad();
        this.estado=studentDTO.getEstado();
    }

}