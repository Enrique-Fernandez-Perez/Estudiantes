package com.example.appBack.Student.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> query = cb.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);

            List<Predicate> predicates = new ArrayList<>();

            String poner = "";//para recoger datos y limpieza visual de codigo

            //if (estudianteDto.getNombre() != null  && estudianteDto.getNombre().trim().length() != 0) {
            if (isStringNull(estudianteDto.getNombre())) {
                poner = estudianteDto.getNombre().trim();
                predicates.add(cb.like(root.get("nombre"), "%" + poner + "%"));
            }

           if (estudianteDto.getApellido() != null  && estudianteDto.getApellido().trim().length() != 0)
           {
                poner = estudianteDto.getApellido().trim();
                predicates.add(cb.equal(root.get("apellido"), "%" + poner + "%"));
            }

           if (estudianteDto.getCorreo() != null  && estudianteDto.getCorreo().trim().length() != 0)
           {
               poner = estudianteDto.getCorreo().trim();
               predicates.add(cb.like(root.get("correo"), "%" + poner + "%"));
           }

           if (estudianteDto.getFecha_entrada() != null)
           {
               Date fecha = estudianteDto.getFecha_entrada();
               predicates.add(cb.equal(root.get("fecha_entrada"), fecha));
           }

           if (estudianteDto.getCiudad() != null  && estudianteDto.getCiudad().trim().length() != 0)
           {
               poner = estudianteDto.getCiudad().trim();
               predicates.add(cb.like(root.get("ciudad"), "%" + poner + "%"));
           }

           if (estudianteDto.getHoras_semanales() != null)
           {
               poner = estudianteDto.getHoras_semanales().toString().trim();
               predicates.add(cb.equal(root.get("horas_semanales"), Integer.parseInt(poner)));
           }

           if (estudianteDto.getEspecialidad() != null && estudianteDto.getEspecialidad().trim().length() != 0)
           {
               poner = "%" + estudianteDto.getEspecialidad().trim() + "%";
               predicates.add(cb.like(root.get("especialidad"), poner));
           }

           if (estudianteDto.getEstado() != null && estudianteDto.getEstado().trim().length() != 0)
           {
               poner = "%" + estudianteDto.getEstado().trim() + "%";
               predicates.add(cb.like(root.get("especialidad"), poner));
           }

            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            List<Student> lista = new ArrayList<>();
            lista.addAll(entityManager.createQuery(query).getResultList());
            return StudentDTO.getAllDTO(lista);
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
        }
        return null;
    }

    private boolean isStringNull(String valor)
    {
        if (valor == null  && valor.trim().length() == 0)
        {
            return true;
        }
        return false;
    }

    private boolean isNull(Object valor)
    {
        if (valor == null)
        {
            return true;
        }
        return false;
    }
}
