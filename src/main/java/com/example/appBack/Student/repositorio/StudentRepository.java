package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String>
{
    //public List<StudentDTO> getQuery(StudentDTO consulta, ArrayList<String> columnas);
    List<StudentDTO> getQuery(StudentDTO consulta);

    //public boolean existNAmeSurname(String name, String surname);
    //public boolean existEmail(String email);

    boolean existNameSurname(StudentDTO sdto);
    Student getStudentbyNameSurname(StudentDTO sdto);
    boolean existEmail(StudentDTO sdto);
    Student getStudentbyEmail(StudentDTO sdto);
}
