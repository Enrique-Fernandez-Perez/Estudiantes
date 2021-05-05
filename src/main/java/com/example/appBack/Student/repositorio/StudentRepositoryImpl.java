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

            HashMap<String, String> listaNull = new HashMap<>();

            String poner = "";//para recoger datos y limpieza de codigo

            //Student estudiante = new Student(estudianteDto);

            if (estudianteDto.getNombre().trim().length() != 0) {
                poner = estudianteDto.getNombre().trim();
                predicates.add(cb.like(root.get("nombre"), "%" + poner + "%"));
            }

            if (estudianteDto.getApellido().trim().length() != 0) {
                poner = estudianteDto.getApellido().trim();
                predicates.add(cb.equal(root.get("apellido"), "%" + poner + "%"));
            }

            if (estudianteDto.getCorreo().trim().length() != 0) {
                poner = estudianteDto.getCorreo().trim();
                predicates.add(cb.like(root.get("correo"), "%" + poner + "%"));
            }

            poner = estudianteDto.getFecha_entrada().toString().trim();
            if (poner.length() != 0) {
                Date fecha = estudianteDto.getFecha_entrada();
                predicates.add(cb.equal(root.get("fecha_entrada"), fecha));
            }

            if (estudianteDto.getCiudad().trim().length() != 0) {
                poner = estudianteDto.getCiudad().trim();
                predicates.add(cb.like(root.get("ciudad"), "%" + poner + "%"));
            }

            if (estudianteDto.getHoras_semanales() != null) {
                poner = estudianteDto.getHoras_semanales().toString().trim();
                predicates.add(cb.equal(root.get("horas_semanales"), Integer.parseInt(poner)));
            }

            if (estudianteDto.getEspecialidad().trim().length() != 0) {
                poner = "%" + estudianteDto.getEspecialidad().trim() + "%";
                predicates.add(cb.like(root.get("especialidad"), poner));
            }

            if (estudianteDto.getEstado().trim().length() != 0) {
                poner = "%" + estudianteDto.getEstado().trim() + "%";
                predicates.add(cb.like(root.get("especialidad"), poner));
                listaNull.put("estado", estudianteDto.getEstado());
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
}
