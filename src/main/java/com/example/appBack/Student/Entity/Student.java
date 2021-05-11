package com.example.appBack.Student.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.Branch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="student")
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

}