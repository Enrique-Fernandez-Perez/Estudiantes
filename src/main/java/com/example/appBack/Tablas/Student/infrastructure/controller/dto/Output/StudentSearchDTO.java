package com.example.appBack.Tablas.Student.infrastructure.controller.dto.Output;

import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.noDatabase.BranchEnum;
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
public class StudentSearchDTO {

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
    private Integer horas_semanales;

    @NotNull
    private String especialidad;

    @NotNull
    private Boolean estado;

    //--------------------NUEVOS-----------------------
    @NotNull
    private String correo_trabajo;

    private String comentarios;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_finalizacion;

    @NotNull
    BranchEnum branch;

    String Profesor;

    public static StudentSearchDTO getStudentSearchDTO(StudentJpa student){
        return new StudentSearchDTO(student.getNombre(),
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
                student.getBranch(),
                student.getProfesor());
    }

    public static List<StudentSearchDTO> getAllDTO(List<StudentJpa> listStudent){
        List<StudentSearchDTO> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudentSearchDTO(student)));
        return devolver;
    }

    public Student convertStudent() {
        return new Student("0", this.getNombre(), this.getApellido(), this.getCorreo(),
                this.getFecha_entrada(), this.getCiudad(), this.getHoras_semanales(),
                this.getEspecialidad(), this.estado, this.getCorreo_trabajo(), this.getComentarios(),
                this.getFecha_finalizacion(), this.getBranch(), this.getProfesor());
    }
}
