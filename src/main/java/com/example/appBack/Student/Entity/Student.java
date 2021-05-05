package com.example.appBack.Student.Entity;

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
@Getter
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

    public void setNombre(String nombre)
    {
        if(nombre.trim().length() != 0)
        {
            this.nombre = nombre;
        }
    }

    public void setApellido(String apellidos)
    {
        if(apellidos.trim().length() != 0)
        {
            this.apellido = apellidos;
        }
    }

    public void setCorreo(String correo)
    {
        if(correo.trim().length() != 0)
        {
            this.correo = correo;
        }
    }

    public void setFecha_entrada(Date fecha_entrada)
    {
        if(fecha_entrada != null)
        {
            this.fecha_entrada = fecha_entrada;
        }
    }

    public void setCiudad(String ciudad)
    {
        if(ciudad.trim().length() != 0)
        {
            this.ciudad = ciudad;
        }
    }

    public void setHoras_semanales(Integer horas_semanales)
    {
        if(horas_semanales != null)
        {
            this.horas_semanales = horas_semanales;
        }
    }

    public void setEspecialidad(String especialidad)
    {
        if(especialidad.trim().length() != 0)
        {
            this.especialidad = especialidad;
        }
    }

    public void setEstado(String estado)
    {
        if(estado.trim().length() != 0)
        {
            this.estado = estado;
        }
    }
}