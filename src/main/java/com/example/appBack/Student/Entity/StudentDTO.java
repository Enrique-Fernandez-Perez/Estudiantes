package com.example.appBack.Student.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String correo;

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

    //--------------------NUEVOS-----------------------
    @NotNull
    private String correo_trabajo;

    @NotNull
    private String comentarios;

    //Branch branch

    @NotNull
    private Date fecha_finalizacion;

    public static StudentDTO getStudentDTO(Student student){
        return new StudentDTO(student.getNombre(),
                student.getApellido(),
                student.getCorreo(),
                student.getFecha_entrada(),
                student.getCiudad(),
                student.getHoras_semanales(),
                student.getEspecialidad(),
                student.getEstado(),
                student.getCorreo_trabajo(),
                student.getComentarios(),
                student.getFecha_finalizacion());
    }

    public static List<StudentDTO> getAllDTO(List<Student> listStudent){
        List<StudentDTO> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudentDTO(student)));
        return devolver;
    }


}