package com.example.appBack.Tablas.TipoRegistro.domain;

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
public class TipoRegistro {

    String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date last_update;

    boolean activo;

    public static TipoRegistro getStudyDTO(TipoRegistroJpa tipoRegistro)
    {
        return new TipoRegistro(tipoRegistro.getName(),
                tipoRegistro.getLast_update(),
                tipoRegistro.isActivo()
        );
    }

    public static List<TipoRegistro> getAllDTO(List<TipoRegistroJpa> listRegistro){
        List<TipoRegistro> devolver = new ArrayList<>();
        listRegistro.forEach(student -> devolver.add(getStudyDTO(student)));
        return devolver;
    }
}