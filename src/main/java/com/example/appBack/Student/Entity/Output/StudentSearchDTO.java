package com.example.appBack.Student.Entity.Output;

import com.sun.istack.NotNull;

import java.util.Date;

public class StudentSearchDTO {

    @NotNull
    private String Surname;

    @NotNull
    private String company_email;

    @NotNull
    private String personal_email;

    @NotNull
    private String city;

    @NotNull
    private Integer numHoursWeek;

    @NotNull
    private String coments;

    //Añadir Branch

    @NotNull
    private Boolean active;

    @NotNull
    private Date createdDate;

    private Date terminationDate;


}
