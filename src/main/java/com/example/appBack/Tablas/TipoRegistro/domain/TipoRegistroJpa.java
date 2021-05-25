package com.example.appBack.Tablas.TipoRegistro.domain;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Nota.domain.NotaJpa;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="tiporegistro")
public class TipoRegistroJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "study_seq")
    @GenericGenerator(
            name = "study_seq",
            strategy = "com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = ""),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")
            })
    @PrimaryKeyJoinColumn
    @NotNull
    private String id_tiporegistro;

    @Column(unique = true)
    String name;

    Date last_update;

    boolean activo;

    @OneToMany(mappedBy = "tipoRegistro", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<NotaJpa> nota;

    public TipoRegistroJpa(TipoRegistro tipoRegistroDTO) {
        //id null
        this.name = "";
        this.last_update = new Date();
        this.activo = true;

        this.setDatos(tipoRegistroDTO);
    }

    public void setDatos(TipoRegistro tipoRegistroDTO) {
        //id null
        this.setName(tipoRegistroDTO.getName());
        this.setLast_update(tipoRegistroDTO.getLast_update());
        this.setActivo(tipoRegistroDTO.isActivo());
    }

    public void setName(String name) {
        if(ComprobarNulos.comprobarString(name)){
            this.name = name;
        }
    }

    public void setLast_update(Date last_update) {
        if(ComprobarNulos.comprobarObjects(last_update)){
            this.last_update = last_update;
        }
    }

    public void setActivo(boolean activo) {
        if(ComprobarNulos.comprobarObjects(activo)){
            this.activo = activo;
        }
    }
}