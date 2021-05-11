package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String>
{
    List<StudentDTO> getQuery(StudentDTO consulta);

    boolean existNameSurname(StudentDTO sdto);
    Student getStudentbyNameSurname(StudentDTO sdto);

    boolean existEmail(StudentDTO sdto);
    Student getStudentbyEmail(StudentDTO sdto);
}
