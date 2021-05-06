package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String>
{
    public List<StudentDTO> getQuery(StudentDTO consulta);
}
