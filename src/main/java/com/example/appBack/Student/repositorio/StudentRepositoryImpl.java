package com.example.appBack.Student.repositorio;

import java.util.ArrayList;
import java.util.Date;
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

    public List<StudentDTO> getQuery(StudentDTO consulta)
    {
        try
        {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> query = cb.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);

            List<Predicate> predicates = new ArrayList<>();

            String nombre = consulta.getNombre();
            String apellido = consulta.getApellido();
            String correo = consulta.getCorreo();
            Date fecha_entrada = consulta.getFecha_entrada();
            Date fecha_finalizacion = consulta.getFecha_finalizacion();
            String ciudad = consulta.getCiudad();
            Integer horas_semanales = consulta.getHoras_semanales();
            String especialidad = consulta.getEspecialidad();
            String correo_trabajo = consulta.getCorreo_trabajo();
            String comentarios = consulta.getComentarios();


            if(comprobarString(nombre)){ predicates.add(cb.equal(root.get("nombre"), nombre));}
            if(comprobarString(apellido)){ predicates.add(cb.equal(root.get("apellido"), apellido));}
            if(comprobarString(correo)){ predicates.add(cb.equal(root.get("correo"), correo));}
            if(compararFechas(fecha_entrada)){ predicates.add(cb.equal(root.get("fecha_entrada"), fecha_entrada));}
            if(compararFechas(fecha_finalizacion)){ predicates.add(cb.equal(root.get("fecha_finalizacion"), fecha_finalizacion));}

            if(comprobarString(ciudad)){ predicates.add(cb.equal(root.get("ciudad"), ciudad));}
            if(comprobarString(especialidad)){ predicates.add(cb.equal(root.get("especialidad"), especialidad));}
            if(comprobarString(comentarios)){ predicates.add(cb.equal(root.get("comentarios"), comentarios));}

            if(comprobarString(correo_trabajo)){ predicates.add(cb.equal(root.get("correo_trabajo"), correo_trabajo));}
            if(comprobarNumbers(horas_semanales)){ predicates.add(cb.equal(root.get("horas_semanales"), horas_semanales));}


            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            List<Student> lista = new ArrayList<>();
            lista.addAll(entityManager.createQuery(query).getResultList());
            return StudentDTO.getAllDTO(lista);
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
            return new ArrayList<>();
        }
    }

    public boolean existNameSurname(StudentDTO sdto)
    {
        Student s = getStudentbyNameSurname(sdto);
        if(s == null)
        {
            return  false;
        }
        return true;
    }

    public Student getStudentbyNameSurname(StudentDTO sdto)
    {
        String name = sdto.getNombre();
        String surname = sdto.getApellido();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("nombre"), name));
        predicates.add(cb.equal(root.get("apellido"), surname));

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getSingleResult();
    }

    public boolean existEmail(StudentDTO sdto)
    {
        Student s = getStudentbyEmail(sdto);
        if(s == null)
        {
            return  false;
        }
        return true;
    }

    public Student getStudentbyEmail(StudentDTO sdto)
    {
        String email = sdto.getCorreo();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("correo"), email));

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getSingleResult();
    }

    private boolean comprobarString(String str)
    {
        if (str.length() != 0)
        {
            return true;
        }
        return false;
    }

    private boolean compararFechas(Date fecha)
    {
        if(fecha != null)
        {
            return true;
        }
        return false;
    }

    private boolean comprobarNumbers(Object num)//Number num)
    {
        try
        {
            if(Double.parseDouble(num.toString()) > 0)
            {
                return true;
            }
        }
        catch (NumberFormatException e){}
        return false;
    }
}
