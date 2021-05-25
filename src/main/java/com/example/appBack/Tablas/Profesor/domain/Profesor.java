package com.example.appBack.Tablas.Profesor.domain;

import com.example.appBack.noDatabase.BranchEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    String id_profesor;

    String id_materia;// string [ref: > materia.id_materia]

    String name;// string [not null]

    String surname;// string  [not null]

    String company_email;// string  [not null]

    String personal_email;// string [not null]

    String city;// string [not null]

    String coments;// string

    BranchEnum branch;// branch [not null]

    boolean active;// boolean  [not null]

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date created_date;// date  [not null]

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date termination_date;// date


    public  static Profesor getProfesorDTO(ProfesorJpa profesorJpa)
    {
        return new Profesor(profesorJpa.getId_profesor(),
                profesorJpa.getId_materia(),
                profesorJpa.getName(),
                profesorJpa.getSurname(),
                profesorJpa.getCompany_email(),
                profesorJpa.getPersonal_email(),
                profesorJpa.getCity(),
                profesorJpa.getComents(),
                profesorJpa.getBranch(),
                profesorJpa.isActive(),
                profesorJpa.getCreated_date(),
                profesorJpa.getTermination_date());
    }

    public static List<Profesor> getAllDTO(List<ProfesorJpa> listStudent){
        List<Profesor> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getProfesorDTO(student)));
        return devolver;
    }
}