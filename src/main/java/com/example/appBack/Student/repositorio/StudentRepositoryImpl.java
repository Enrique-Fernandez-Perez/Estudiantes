package com.example.appBack.Student.repositorio;

import java.util.ArrayList;
import java.util.Date;
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
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> query = cb.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);

            List<Predicate> predicates = new ArrayList<>();

            HashMap<String, String> listaNull = new HashMap<>();

            String poner = "";//para recoger datos y limpieza de codigo

            Student estudiante = new Student(estudianteDto);

            if (estudiante.getNombre().trim().length() != 0) {
                poner = estudiante.getNombre().toUpperCase().trim();
                predicates.add(cb.like(root.get("nombre"), "%" + poner + "%"));
            }

            if (estudiante.getApellido().trim().length() != 0) {
                poner = estudiante.getApellido().toUpperCase().trim();
                predicates.add(cb.equal(root.get("apellido"), "%" + poner + "%"));
            }

            if (estudiante.getCorreo().trim().length() != 0) {
                poner = estudiante.getCorreo().toUpperCase().trim();
                predicates.add(cb.like(root.get("correo"), "%" + poner + "%"));
            }

            poner = estudiante.getFecha_entrada().toString().trim();
            if (poner.length() != 0) {
                Date fecha = estudiante.getFecha_entrada();
                predicates.add(cb.equal(root.get("fecha_entrada"), fecha));
            }

            if (estudiante.getCiudad().trim().length() != 0) {
                poner = estudiante.getCiudad().trim().toUpperCase();
                predicates.add(cb.like(root.get("ciudad"), "%" + poner + "%"));
            }

            if (estudiante.getHoras_semanales() != null) {
                poner = estudiante.getHoras_semanales().toString().trim().toUpperCase();
                predicates.add(cb.equal(root.get("horas_semanales"), Integer.parseInt(poner)));
            }

            if (estudiante.getEspecialidad().trim().length() != 0) {
                poner = "%" + estudiante.getEspecialidad().trim().toUpperCase() + "%";
                predicates.add(cb.like(root.get("especialidad"), poner));
            }

            if (estudiante.getEstado().trim().length() != 0) {
                poner = "%" + estudiante.getEstado().trim().toUpperCase() + "%";
                predicates.add(cb.like(root.get("especialidad"), poner));
                listaNull.put("estado", estudiante.getEstado());
            }

            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            List<Student> lista = entityManager.createQuery(query).getResultList();
            return StudentDTO.getAllDTO(lista);
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
        }
        return null;
    }
}
