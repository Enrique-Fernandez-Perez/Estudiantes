package com.example.appBack.Student.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dom4j.Branch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Data
//@Table(name="student")
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            //name = "ausencias_seq",
            name = "estudiantes_seq",
            //strategy = "com.bosonit.staffit.shared.sequences.StringPrefixedSequenceIdGenerator",
            strategy = "com.example.appBack.Student.Entity.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String correo;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_entrada;

    @NotNull
    private String ciudad;

    @NotNull
    private Integer horas_semanales;

    @NotNull
    private String especialidad;

    @NotNull
    private Boolean estado;
    //private String estado;

    @NotNull
    private String correo_trabajo;

    @NotNull
    private String comentarios;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_finalizacion;

    @NotNull
    branch branch;

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
        this.comentarios = studentDTO.getComentarios();
        this.fecha_finalizacion = studentDTO.getFecha_finalizacion();
        this.correo_trabajo = studentDTO.getCorreo_trabajo();
        this.branch = studentDTO.getBranch();
    }

    public void setDatos(StudentDTO studentDTO){
        //id null
        this.setNombre(studentDTO.getNombre());
        this.setApellido(studentDTO.getApellido());
        this.setCorreo(studentDTO.getCorreo());
        this.setFecha_entrada(studentDTO.getFecha_entrada());

        this.setCiudad(studentDTO.getCiudad());
        this.setHoras_semanales(studentDTO.getHoras_semanales());
        this.setEspecialidad(studentDTO.getEspecialidad());
        this.setEstado(studentDTO.getEstado());

        this.setComentarios(studentDTO.getComentarios());
        this.setFecha_finalizacion(studentDTO.getFecha_finalizacion());
        this.setCorreo_trabajo(studentDTO.getCorreo_trabajo());
        this.setBranch(studentDTO.getBranch());
    }

    private void setNombre(String nombre) {
        if(comprobarString(nombre))
        {
            this.nombre = nombre;
        }
    }

    private void setApellido(String apellido) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
    }

    private void setCorreo(String correo) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
        this.correo = correo;
    }

    private void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    private void setCiudad(String ciudad) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
        this.ciudad = ciudad;
    }

    private void setHoras_semanales(Integer horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    private void setEspecialidad(String especialidad) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
        this.especialidad = especialidad;
    }

    private void setEstado(Boolean estado) {

        this.estado = estado;
    }

    private void setCorreo_trabajo(String correo_trabajo) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
        this.correo_trabajo = correo_trabajo;
    }

    private void setComentarios(String comentarios) {
        if(comprobarString(apellido))
        {
            this.apellido = apellido;
        }
        this.comentarios = comentarios;
    }

    private void setFecha_finalizacion(Date fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    private void setBranch(branch branch) {
        this.branch = branch;
    }

    private boolean comprobarString(String str)
    {
        if (str.length() != 0 && str != null)
        {
            return true;
        }
        return false;
    }

    private boolean compararFechas(Date fecha)
    {
        if(fecha != null)
        {
            return true;
        }
        return false;
    }

    private boolean comprobarNumbers(Object num)
    {
        try
        {
            if(Double.parseDouble(num.toString()) > 0)
            {
                return true;
            }
        }
        catch (NumberFormatException e){}
        return false;
    }

    private boolean comprobarObjects(Object objeto)
    {
        if(objeto != null){
            return true;
        }
        return false;
    }
}