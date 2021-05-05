package com.example.appBack.Student.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    private String correo;

    private Date fecha_entrada;

    private String ciudad;

    private Integer horas_semanales;

    private String especialidad;

    private String estado;


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