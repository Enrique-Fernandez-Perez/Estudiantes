package com.example.appBack.Tablas.Study.domain;

import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Materia.domain.MateriaJpa;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="study")
public class StudyJpa {

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
    private String id_study;

    String id_student;// [ref: > student.id_student]

    String id_materia;// string [ref: > materia.id_materia]

    @NotNull
    float note;

    String coment;

    @NotNull
    Date initialDate;

    @NotNull
    Date finishDate;

    @ManyToOne()
    //@JoinColumn(name = "fk_student")
    private StudentJpa estudiante;

    @ManyToOne()
    //@JoinColumn(name = "fk_materia")
    private MateriaJpa materia;


    public StudyJpa(Study studyDTO){
        //id null
        this.id_student = "";
        this.id_materia = "";
        this.note = 0;
        this.coment = "";
        this.initialDate = new Date();
        this.finishDate = new Date();

        this.setDatos(studyDTO);
    }

    public void setDatos(Study studyDTO){
        //id null
        this.setId_student("");
        this.setId_materia("");
        this.setNote(0);
        this.setComent("");
        if(compararFechas(studyDTO.getInitialDate(), studyDTO.getFinishDate())) {
            this.setInitialDate(new Date());
            this.setFinishDate(new Date());
        }
    }

    public void setId_student(String id_student) {
        if(comprobarString(id_student)){
            this.id_student = id_student;
        }
    }

    public void setId_materia(String id_materia) {
        if(comprobarString(id_materia)){
            this.id_materia = id_materia;
        }
    }

    public void setNote(float note) {
        if(comprobarNumbers(note)){
            this.note = note;
        }
    }

    public void setComent(String coment) {
        if(comprobarString(coment)){
            this.coment = coment;
        }
    }

    public void setInitialDate(Date initialDate) {
        if(comprobarFechas(initialDate)){
            this.initialDate = initialDate;
        }
    }

    public void setFinishDate(Date finishDate) {
        if(comprobarFechas(finishDate)){
            this.finishDate = finishDate;
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

    private boolean comprobarFechas(Date fecha)
    {
        try {
            if (fecha != null) {
                return true;
            }

        }catch(Exception e){e.printStackTrace();}
        return false;
    }

    private boolean comprobarNumbers(Object num)
    {
        try
        {
            if(num != null && Double.parseDouble(num.toString()) > 0)
            {
                return true;
            }
        }
        catch (NumberFormatException e){}
        return false;
    }

    private boolean compararFechas(Date alta, Date baja)
    {
        try {
            if(comprobarFechas(alta) && !comprobarFechas(baja)){
                return true;
            }
            if(comprobarFechas(alta) && comprobarFechas(baja)){
                return alta.before(baja);
            }

        }catch(Exception e){e.printStackTrace();}
        return false;
    }
}