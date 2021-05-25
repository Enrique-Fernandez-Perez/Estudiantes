package com.example.appBack.Tablas.Profesor.domain;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator;
import com.example.appBack.Tablas.Materia.domain.MateriaJpa;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.noDatabase.BranchEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="profesor")
public class ProfesorJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesores_seq")
    @GenericGenerator(
            name = "profesores_seq",
            strategy = "com.example.appBack.Generadores.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = ""),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")
            })
    @NotNull
    @PrimaryKeyJoinColumn
    String id_profesor;// string [pk, increment]

    String id_materia;// string [ref: > materia.id_materia]

    @NotNull
    String name;// string [not null]

    @NotNull
    String surname;// string  [not null]

    @NotNull
    String company_email;// string  [not null]

    @NotNull
    String personal_email;// string [not null]

    @NotNull
    String city;// string [not null]

    String coments;// string

    @NotNull
    BranchEnum branch;// branch [not null]

    @NotNull
    boolean active;// boolean  [not null]

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date created_date;// date  [not null]

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date termination_date;// date

    @OneToMany(mappedBy = "profesorJpa", cascade = CascadeType.ALL)
    public List<StudentJpa> estudiante;

    @ManyToOne(cascade = CascadeType.ALL)
    MateriaJpa materiaJpa;

    public ProfesorJpa(Profesor profesor){
        //id null
        Date fecha = new Date();

        this.id_materia = "";
        this.name = "";
        this.surname = "";
        this.company_email = "";
        this.personal_email = "";
        this.city = "";
        this.coments = "";
        this.branch = BranchEnum.DEVOPS;
        this.active = true;
        this.created_date = fecha;
        this.termination_date = fecha;

        this.setDatos(profesor);
    }

    public void setDatos(Profesor profesor){
        //id null
        this.setId_materia(profesor.id_materia);

        this.setName(profesor.getName());
        this.setSurname(profesor.getSurname());

        this.setPersonal_email(profesor.getPersonal_email());
        this.setCompany_email(profesor.getCompany_email());

        this.setCreated_date(profesor.getCreated_date());
        this.setTermination_date(profesor.getTermination_date());

        this.setCity(profesor.getCity());
        this.setActive(profesor.isActive());

        this.setComents(profesor.getComents());
        this.setBranch(profesor.getBranch());
    }

    public void setId_materia(String id_materia){
        if(ComprobarNulos.comprobarString(id_materia)){
            this.id_materia = id_materia;
        }
    }

    public void setName(String name){
        if(ComprobarNulos.comprobarString(name)){
            this.name = name;
        }
    }

    public void setSurname(String surname){
        if(ComprobarNulos.comprobarString(surname)){
            this.surname = surname;
        }
    }

    public void setCompany_email(String company_email){
        if(ComprobarNulos.comprobarString(company_email)){
            this.company_email = company_email;
        }
    }

    public void setPersonal_email(String personal_email){
        if(ComprobarNulos.comprobarString(personal_email)){
            this.personal_email = personal_email;
        }
    }

    public void setCity(String city) {
        if(ComprobarNulos.comprobarString(city)){
            this.city = city;
        }
    }

    public void setComents(String coments) {
        if(ComprobarNulos.comprobarString(coments)){
            this.coments = coments;
        }
    }

    public void setBranch(BranchEnum branch) {
        if(ComprobarNulos.comprobarObjects(branch)){
            this.branch = branch;
        }
    }

    public void setActive(boolean active) {
        if(ComprobarNulos.comprobarObjects(active)){
            this.active = active;
        }
    }

    public void setCreated_date(Date created_date) {
        if(ComprobarNulos.comprobarObjects(created_date)){
            this.created_date = created_date;
        }
    }

    public void setTermination_date(Date termination_date) {
        if (ComprobarNulos.comprobarObjects(termination_date)){
            this.termination_date = termination_date;
        }
    }
}