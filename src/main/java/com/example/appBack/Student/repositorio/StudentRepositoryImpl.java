package com.example.appBack.Student.repositorio;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;


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
            String estado = consulta.getEstado();
            String correo_trabajo = consulta.getCorreo_trabajo();
            String comentarios = consulta.getComentarios();


            if(comprobarString(nombre)){ predicates.add(cb.equal(root.get("nombre"), nombre));}
            if(comprobarString(apellido)){ predicates.add(cb.equal(root.get("apellido"), apellido));}
            if(comprobarString(correo)){ predicates.add(cb.equal(root.get("correo"), correo));}
            if(compararFechas(fecha_entrada)){ predicates.add(cb.equal(root.get("fecha_entrada"), fecha_entrada));}
            if(compararFechas(fecha_finalizacion)){ predicates.add(cb.equal(root.get("fecha_finalizacion"), fecha_finalizacion));}

            if(comprobarString(ciudad)){ predicates.add(cb.equal(root.get("ciudad"), ciudad));}
            if(comprobarString(especialidad)){ predicates.add(cb.equal(root.get("especialidad"), especialidad));}
            if(comprobarString(estado)){ predicates.add(cb.equal(root.get("estado"), estado));}
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

    //public boolean existNameSurname(String name, String surname)
    public boolean existNameSurname(StudentDTO sdto)
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
        /**int primero = entityManager.createQuery(query).getFirstResult();
        if(primero == 0){
            return false;
        }*/
        List<Student> s = entityManager.createQuery(query).getResultList();
        if(s.size() == 0)
        {
            return  false;
        }
        return true;
    }

    //public boolean existEmail(String email)
    public boolean existEmail(StudentDTO sdto)
    {
        String email = sdto.getCorreo();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("correo"), email));

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        //int primero = entityManager.createQuery(query).getFirstResult();
        /*if(primero == 0){
            return false;
        }*/
        List<Student> s = entityManager.createQuery(query).getResultList();
        if(s.size() == 0)
        {
            return  false;
        }
        return true;
    }

    /*private boolean comprobar(String comprobacion, Object objectAComprobar)
    {
        if(objectAComprobar.getClass().getTypeName().equalsIgnoreCase("STRING"))
        {
            String comprobar = ((String) objectAComprobar).trim();
            if(comprobarString(comprobar))
            {
                //predicates.add(cb.like(root.get(columna), "%" + comprobar + "%"));
                //predicates.add(cb.equal(root.get(columna),  comprobar));
            }
        }
        if(comprobarNumbers(objectAComprobar))
        {
            //predicates.add(cb.equal(root.get(columna), Double.parseDouble(""+dato)));
            return true;
        }
        if(objectAComprobar.getClass().getTypeName().equalsIgnoreCase("DATE"))
        {
            //predicates.add(cb.equal(root.get(columna), (Date)dato));
            return true;
        }
        return false;
    }*/

    /*public List<StudentDTO> getQuery(StudentDTO estudianteDto, ArrayList<String> columnas)
    {
        try
        {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> query = cb.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);

            List<Predicate> predicates = new ArrayList<>();

            String nombre = estudianteDto.getNombre();
            String apellido = estudianteDto.getApellido();
            String correo = estudianteDto.getCorreo();
            Date fecha_entrada = estudianteDto.getFecha_entrada();
            Date fecha_finalizacion = estudianteDto.getFecha_finalizacion();
            String ciudad = estudianteDto.getCiudad();
            Integer horas_semanales = estudianteDto.getHoras_semanales();
            String especialidad = estudianteDto.getEspecialidad();
            String estado = estudianteDto.getEstado();
            String correo_trabajo = estudianteDto.getCorreo_trabajo();
            String comentarios = estudianteDto.getComentarios();

            Object[] datos = {nombre,apellido,correo,fecha_entrada,fecha_finalizacion,ciudad,horas_semanales,especialidad,estado, correo_trabajo, comentarios};

            final int[] i = {0};

            /*if(!compararFechas(fecha_entrada,fecha_finalizacion))
            {
                return null;
            }*/

            /*columnas.forEach(columna ->
            {
                Object dato = datos[i[0]];

                if(dato.getClass().getTypeName().equalsIgnoreCase("STRING"))
                {
                    String comprobar = ((String) dato).trim();
                    if(comprobarString(comprobar))
                    {
                        //predicates.add(cb.like(root.get(columna), "%" + comprobar + "%"));
                        predicates.add(cb.equal(root.get(columna),  comprobar));
                    }
                }
                if(comprobarNumbers(dato))
                {
                    predicates.add(cb.equal(root.get(columna), Double.parseDouble(""+dato)));
                }
                if(datos[i[0]].getClass().getTypeName().equalsIgnoreCase("DATE"))
                {
                    predicates.add(cb.equal(root.get(columna), (Date)dato));
                }
                i[0]++;
            });

            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            List<Student> lista = new ArrayList<>();
            lista.addAll(entityManager.createQuery(query).getResultList());
            return StudentDTO.getAllDTO(lista);
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
            return new ArrayList<>();
        }
        //return null;
    }*/

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

    /**private boolean compararFechas(Date fecha1, Date fecha2)
    {
        if(fecha1.before(fecha2))
        {
            return true;
        }
        return false;
    }*/

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
