package com.example.appBack.Student.Entity.Input;

import com.example.appBack.Student.Entity.Output.StudentOutputDTO;
import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.branch;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String correo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_entrada;

    @NotNull
    private String ciudad;

    @NotNull
    private int horas_semanales;

    @NotNull
    private String especialidad;

    @NotNull
    private boolean estado;

    //--------------------NUEVOS-----------------------
    @NotNull
    private String correo_trabajo;

    private String comentarios;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_finalizacion;

    @NotNull
    branch branch;

    public static StudentInputDTO getStudentInputDTO(Student student){
        return new StudentInputDTO(student.getNombre(),
                student.getApellido(),
                student.getCorreo(),
                student.getFecha_entrada(),
                student.getCiudad(),
                student.getHoras_semanales(),
                student.getEspecialidad(),
                student.getEstado(),
                student.getCorreo_trabajo(),
                student.getComentarios(),
                student.getFecha_finalizacion(),
                student.getBranch());
    }

    public static List<StudentInputDTO> getAllDTO(List<Student> listStudent){
        List<StudentInputDTO> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudentInputDTO(student)));
        return devolver;
    }

/**
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

    @NotNull
    private Date fecha_finalizacion;
*/
}
