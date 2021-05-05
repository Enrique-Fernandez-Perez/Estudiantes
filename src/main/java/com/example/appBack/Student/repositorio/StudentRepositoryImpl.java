package com.example.appBack.Student.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;

public class StudentRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;

    public List<StudentDTO> getQuery(StudentDTO estudianteDto)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query= cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        HashMap<String, String> listaNull = new HashMap<>();

        String poner = "";

        Student estudiante = new Student(estudianteDto);

        if(estudiante.getNombre().trim().length()!=0)
        {
            poner = estudiante.getNombre().toUpperCase().trim();
            predicates.add(cb.like (root.get("nombre"), "%"+poner+"%"));
        }

        if(estudiante.getApellido().trim().length()!=0)
        {
            poner = estudiante.getApellido().toUpperCase().trim();
            predicates.add(cb.equal (root.get("apellido"), "%"+poner+"%"));
        }

        if(estudiante.getCorreo().trim().length()!=0)
        {
            poner = estudiante.getCorreo().toUpperCase().trim();
            predicates.add(cb.like(root.get("correo"), "%"+poner+"%"));
        }

        if(estudiante.getFecha_entrada().toString().trim().length()!=0){listaNull.put("fecha_entrada", estudiante.getApellido().toString());}

        if(estudiante.getCiudad().trim().length()!=0){listaNull.put("ciudad", estudiante.getCiudad());}

        if(estudiante.getHoras_semanales()!=null){listaNull.put("horas_semanales", estudiante.getHoras_semanales().toString());}

        if(estudiante.getEspecialidad().trim().length()!=0){listaNull.put("especialidad", estudiante.getEspecialidad());}

        if(estudiante.getEstado().trim().length()!=0){listaNull.put("estado", estudiante.getEstado());}

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        List<Student> lista = entityManager.createQuery(query).getResultList();
        return StudentDTO.getAllDTO(lista);
    }
}
