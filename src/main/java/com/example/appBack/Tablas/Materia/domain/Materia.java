package com.example.appBack.Tablas.Materia.domain;

import com.example.appBack.noDatabase.BranchEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    String id;

    @NotNull
    BranchEnum branch;

    String name;

    String description;

    public static Materia getStudyDTO(MateriaJpa study)
    {
        return new Materia(study.getId_materia(),
                study.getBranch(),
                study.getName(),
                study.getDescription()
        );
    }

    public static List<Materia> getAllDTO(List<MateriaJpa> listStudent){
        List<Materia> devolver = new ArrayList<>();
        listStudent.forEach(student -> devolver.add(getStudyDTO(student)));
        return devolver;
    }
}