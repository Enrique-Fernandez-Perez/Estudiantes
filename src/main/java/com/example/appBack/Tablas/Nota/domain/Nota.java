package com.example.appBack.Tablas.Nota.domain;

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
public class Nota {

    String id_student;

    String id_tiporegistro;

    @NotNull
    float note;

    @NotNull
    BranchEnum branch;

    String id_materia;

    String coment;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    Date creationDate;

    public static Nota getStudyDTO(NotaJpa nota)
    {
        return new Nota(nota.getId_student(),
        nota.getId_tiporegistro(),
        nota.getNote(),
        nota.getBranch(),
        nota.getId_materia(),
        nota.getComent(),
        nota.getCreationDate()
        );
    }

    public static List<Nota> getAllDTO(List<NotaJpa> listNota){
        List<Nota> devolver = new ArrayList<>();
        listNota.forEach(student -> devolver.add(getStudyDTO(student)));
        return devolver;
    }
}