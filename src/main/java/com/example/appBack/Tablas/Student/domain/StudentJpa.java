package com.example.appBack.Tablas.Student.domain;

import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Nota.domain.NotaJpa;
import com.example.appBack.Tablas.Profesor.domain.ProfesorJpa;
import com.example.appBack.Tablas.Study.domain.StudyJpa;
import com.example.appBack.noDatabase.BranchEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="student")
public class StudentJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            name = "estudiantes_seq",
            strategy = "com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @NotNull
    private String id_Student;

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
    BranchEnum branch;

    String Profesor;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "id_headers_facture")

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<NotaJpa> nota;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<StudyJpa> study;

    @ManyToOne(cascade = CascadeType.ALL)
    ProfesorJpa profesorJpa;

    public StudentJpa(Student studentDTO){
        //id null
        Date fecha = new Date();

        this.nombre="";//studentDTO.getNombre();
        this.apellido="";//studentDTO.getApellido();
        this.correo="";//studentDTO.getCorreo();
        this.fecha_entrada=fecha;//studentDTO.getFecha_entrada();
        this.ciudad="";//studentDTO.getCiudad();
        this.horas_semanales=10;//studentDTO.getHoras_semanales();
        this.especialidad="";//studentDTO.getEspecialidad();
        this.estado=true;//studentDTO.getEstado();
        this.comentarios = "";//studentDTO.getComentarios();
        this.fecha_finalizacion = fecha;//studentDTO.getFecha_finalizacion();
        this.correo_trabajo = "";//studentDTO.getCorreo_trabajo();
        this.branch = branch.FRONT;//studentDTO.getBranch();

        this.setDatos(studentDTO);
    }

    public void setDatos(Student studentDTO){
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
        if(comprobarString(correo))
        {
            this.correo = correo;
        }
    }

    private void setFecha_entrada(Date fecha_entrada) {
        if(comprobarFechas(fecha_entrada)){
            this.fecha_entrada = fecha_entrada;
        }
    }

    private void setCiudad(String ciudad) {
        if(comprobarString(ciudad))
        {
            this.ciudad = ciudad;
        }
    }

    private void setHoras_semanales(Integer horas_semanales) {
        if(comprobarNumbers(horas_semanales)){
            this.horas_semanales = horas_semanales;
        }
    }

    private void setEspecialidad(String especialidad) {
        if(comprobarString(especialidad))
        {
            this.especialidad = especialidad;
        }
    }

    private void setEstado(Boolean estado) {
        if(comprobarObjects(estado)) {
            this.estado = estado;
        }
    }

    private void setCorreo_trabajo(String correo_trabajo) {
        if(comprobarString(correo_trabajo))
        {
            this.correo_trabajo = correo_trabajo;
        }
    }

    private void setComentarios(String comentarios) {
        if(comprobarString(comentarios))
        {
            this.comentarios = comentarios;
        }
    }

    private void setFecha_finalizacion(Date fecha_finalizacion) {
        if(comprobarFechas(fecha_finalizacion)){
            this.fecha_finalizacion = fecha_finalizacion;
        }
    }

    private void setBranch(BranchEnum branch) {
        if(comprobarObjects(branch)){
            this.branch = branch;
        }
    }

    private boolean comprobarString(String str)
    {
        try {
            if (str.trim().length() != 0 && str != null)
            {
                return true;
            }
        }catch (Exception e) { }
        return false;
    }

    private boolean comprobarFechas(Date fecha)
    {
        try {
            if (fecha != null) {
                return true;
            }

        }catch(Exception e){e.printStackTrace();}
        return false;
    }

    private boolean comprobarNumbers(Object num)
    {
        try
        {
            if(num != null && Double.parseDouble(num.toString()) > 0)
            {
                return true;
            }
        }
        catch (NumberFormatException e){}
        return false;
    }

    private boolean comprobarObjects(Object objeto)
    {
        try {
            if (objeto != null) {
                return true;
            }
        }catch(Exception e){ }
        return false;
    }
}