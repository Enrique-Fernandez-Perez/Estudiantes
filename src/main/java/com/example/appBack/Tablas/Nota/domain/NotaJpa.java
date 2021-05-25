package com.example.appBack.Tablas.Nota.domain;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Materia.domain.MateriaJpa;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.Tablas.TipoRegistro.domain.TipoRegistroJpa;
import com.example.appBack.noDatabase.BranchEnum;
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
@Table(name="nota")
public class NotaJpa {

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
    private String id_notas;// String [pk, increment]

    String id_student;// string [ref: > student.id_student]

    String id_tiporegistro;// string  [ref: > tiporegistro.id_tiporegistro]

    @NotNull
    float note;// float [not null] // Puede ser negativo

    @NotNull
    BranchEnum branch;// [not null]

    String id_materia;// string [ref: > materia.id_materia]

    String coment;// string

    @NotNull
    Date creationDate;// date [not null]

    @ManyToOne()
    //@JoinColumn(name = "fk_student")
    private StudentJpa estudiante;

    @ManyToOne()
    //@JoinColumn(name = "fk_materia")
    private MateriaJpa materia;

    @ManyToOne()
    //@JoinColumn(name = "fk_tipo_registro")
    private TipoRegistroJpa tipoRegistro;

    public NotaJpa(Nota notaDTO) {
        //id null
        this.note = 2;
        this.branch = BranchEnum.FRONT;
        this.coment = "";
        this.creationDate = new Date();

        this.setDatos(notaDTO);
    }

    public void setDatos(Nota notaDTO) {
        //id null
        this.setId_student(notaDTO.getId_student());
        this.setId_tiporegistro(notaDTO.getId_tiporegistro());
        this.setNote(notaDTO.getNote());
        this.setBranch(notaDTO.getBranch());
        this.setId_materia(notaDTO.getId_materia());
        this.setComent(notaDTO.getComent());
        this.setCreationDate(notaDTO.getCreationDate());
    }

    public void setId_student(String id_student) {
        if(ComprobarNulos.comprobarString(id_student)){
            this.id_student = id_student;
        }
    }

    public void setId_tiporegistro(String id_tiporegistro) {
        if(ComprobarNulos.comprobarString(id_tiporegistro)){
            this.id_tiporegistro = id_tiporegistro;
        }
    }

    public void setNote(float note) {
        if(ComprobarNulos.comprobarObjects(note)){
            this.note = note;
        }
    }

    public void setBranch(BranchEnum branch) {
        if(ComprobarNulos.comprobarObjects(branch)){
            this.branch = branch;
        }
    }

    public void setId_materia(String id_materia) {
        if(ComprobarNulos.comprobarString(id_materia)){
            this.id_materia = id_materia;
        }
    }

    public void setComent(String coment) {
        if(ComprobarNulos.comprobarString(coment)){
            this.coment = coment;
        }
    }

    public void setCreationDate(Date creationDate) {
        if(ComprobarNulos.comprobarObjects(creationDate)){
            this.creationDate = creationDate;
        }
    }
}