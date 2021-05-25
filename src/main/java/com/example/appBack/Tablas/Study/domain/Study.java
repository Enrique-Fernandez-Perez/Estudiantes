package com.example.appBack.Tablas.Study.domain;

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
public class Study {

    String id_student;
    String id_materia;

    @NotNull
    float note;

    String coment;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    Date initialDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    Date finishDate;

    public static Study getStudyDTO(StudyJpa study)
    {
        return new Study(study.getId_study(),
        study.getId_materia(),
        study.getNote(),
        study.getComent(),
        study.getInitialDate(),
        study.getFinishDate());
    }

    public static List<Study> getAllDTO(List<StudyJpa> listStudent){
        List<Study> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudyDTO(student)));
        return devolver;
    }

    public boolean compararFechas(Study studyDTO)
    {
        try{
            Date fecha1 = studyDTO.getInitialDate();
            Date fecha2 = studyDTO.getFinishDate();

            if(fecha1 != null && fecha2 == null){
                return true;
            }
            if(fecha1 != null && fecha2 != null){
                return fecha1.before(fecha2);
            }

            return fecha1.before(fecha2);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}