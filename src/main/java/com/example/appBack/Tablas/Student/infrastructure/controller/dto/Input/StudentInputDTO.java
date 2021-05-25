package com.example.appBack.Tablas.Student.infrastructure.controller.dto.Input;

import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.noDatabase.BranchEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(example = "01/01/2021 tihs format because input required in JSON is day/month/year")
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

    @ApiModelProperty(example = "20/02/2040 this format because input required in JSON is day/month/year")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_finalizacion;

    @NotNull
    BranchEnum branch;

    String Profesor;

    public static StudentInputDTO getStudentInputDTO(StudentJpa student){
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
                student.getBranch(),
                student.getProfesor());
    }

    public Student InputToDTO(){
       return new Student("0",this.getNombre(),this.getApellido(),this.getCorreo(),
                this.getFecha_entrada(),this.getCiudad(),this.getHoras_semanales(),
                this.getEspecialidad(),this.isEstado(),this.getCorreo_trabajo(),this.getComentarios(),
                        this.getFecha_finalizacion(),this.getBranch(), this.getProfesor());
    }

    public static List<StudentInputDTO> getAllDTO(List<StudentJpa> listStudent){
        List<StudentInputDTO> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudentInputDTO(student)));
        return devolver;
    }

}
