package com.example.appBack.Tablas.Materia.domain;

import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Nota.domain.NotaJpa;
import com.example.appBack.Tablas.Profesor.domain.ProfesorJpa;
import com.example.appBack.Tablas.Study.domain.StudyJpa;
import com.example.appBack.noDatabase.BranchEnum;
import com.sun.istack.NotNull;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="materia")
public class MateriaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
    @GenericGenerator(
            name = "materia_seq",
            strategy = "com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = ""),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")
            })
    @PrimaryKeyJoinColumn
    @NotNull
    private String id_materia;

    @NotNull
    @Unsigned
    BranchEnum branch;

    String name;

    String description;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<NotaJpa> nota;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<StudyJpa> study;

    @OneToMany(mappedBy = "materiaJpa", cascade = CascadeType.ALL)
    public List<ProfesorJpa> profesorJpas;

    public MateriaJpa(Materia materiaDTO){
        //id null
        this.branch = BranchEnum.FRONT;
        this.name = "";
        this.description = "";

        this.setDatos(materiaDTO);
    }

    public void setDatos(Materia materiaDTO){
        //id null
        this.setBranch(materiaDTO.getBranch());
        this.setName("");
        this.setDescription("");
    }

    public void setBranch(BranchEnum branch) {
        if(comprobarObjects(branch)){
            this.branch = branch;
        }
    }

    public void setName(String name) {
        if(comprobarString(name)){
            this.name = name;
        }
    }

    public void setDescription(String description) {
        if(comprobarString(description)){
            this.description = description;
        }
    }

    private boolean comprobarString(String str)
    {
        try {
            if (str.trim().length() != 0 && str != null)
            {
                return true;
            }
        }catch (Exception e) { }
        return false;
    }

    private boolean comprobarObjects(Object objeto)
    {
        try {
            if (objeto != null) {
                return true;
            }
        }catch(Exception e){ }
        return false;
    }
}