package com.example.appBack.Tablas.Student.domain;

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
public class Student {

    private String id;

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
    //private String estado;

    //--------------------NUEVOS-----------------------
    @NotNull
    private String correo_trabajo;

    private String comentarios;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_finalizacion;

    @NotNull
    BranchEnum branch;

    String Profesor;

    public static Student getStudentDTO(StudentJpa student){
        return new Student(student.getId_Student(),
                student.getNombre(),
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
                student.getProfesor()
        );
    }

    public static List<Student> getAllDTO(List<StudentJpa> listStudent){
        List<Student> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudentDTO(student)));
        return devolver;
    }

    public List dtoInputComprobador(Student e) {
        List<String> msgError = new ArrayList<>();
        if (nombre== null ||
                apellido == null ||
                correo_trabajo == null ||
                correo == null ||
                ciudad == null ||
                comentarios == null ||
                branch == null ||
                fecha_entrada == null ||
                fecha_finalizacion == null
        )
            msgError.add("-Campos Vacios-");

        if (nombre.matches("^[0-9]+$") ||
                apellido.matches("^[0-9]+$") ||
                ciudad.matches("^[0-9]+$")

        )
            msgError.add("-Campos con caracteres no validos-");

        return  msgError;
    }

    public boolean comprobadorFechas(Student estudianteInputDto){

        if(estudianteInputDto.getFecha_finalizacion() == null || estudianteInputDto.getFecha_entrada() == null){
            return true;
        }else{
            return estudianteInputDto.getFecha_entrada().before(estudianteInputDto.getFecha_finalizacion());
        }
    }

    public boolean compararFechas(Student sdto)
    {
        Date fecha1 = sdto.getFecha_entrada();
        Date fecha2 = sdto.getFecha_finalizacion();

        if(fecha1 != null && fecha2 == null){
            return true;
        }
        if(fecha1 != null && fecha2 != null){
            return fecha1.before(fecha2);
        }

        return false;
    }
}