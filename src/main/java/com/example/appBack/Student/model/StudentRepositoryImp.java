package com.example.appBack.Student.model;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepositoryImp
{
    @PersistenceContext
    private EntityManager entityManager;

    public List<StudentDTO> getConsulta(StudentDTO estudianteDto)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query= cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        HashMap<String, String> listaNull = new HashMap<>();

        String poner = "";

        if(estudianteDto.getNombre().trim().length()!=0)
        {
            poner = estudianteDto.getNombre().toUpperCase().trim();
            predicates.add(cb.like(root.get("upper(nombre)"), "%"+poner+"%"));
        }

        if(estudianteDto.getApellido().trim().length()!=0)
        {
            poner = estudianteDto.getApellido().toUpperCase().trim();
            predicates.add(cb.like(root.get("upper(apellido)"), "%"+poner+"%"));
        }

        if(estudianteDto.getCorreo().trim().length()!=0)
        {
            poner = estudianteDto.getCorreo().toUpperCase().trim();
            predicates.add(cb.like(root.get("upper(correo)"), "%"+poner+"%"));
        }

        if(estudianteDto.getFecha_entrada().toString().trim().length()!=0){listaNull.put("fecha_entrada", estudianteDto.getApellido().toString());}

        if(estudianteDto.getCiudad().trim().length()!=0){listaNull.put("ciudad", estudianteDto.getCiudad());}

        if(estudianteDto.getHoras_semanales()!=null){listaNull.put("horas_semanales", estudianteDto.getHoras_semanales().toString());}

        if(estudianteDto.getEspecialidad().trim().length()!=0){listaNull.put("especialidad", estudianteDto.getEspecialidad());}

        if(estudianteDto.getEstado().trim().length()!=0){listaNull.put("estado", estudianteDto.getEstado());}

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        List<Student> lista = entityManager.createQuery(query).getResultList();
        return StudentDTO.getAllDTO(lista);
        //return null;
    }
}
