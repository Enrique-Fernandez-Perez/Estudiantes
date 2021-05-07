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

public class StudentRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;

    public List<StudentDTO> getQuery(StudentDTO estudianteDto, ArrayList<String> columnas)
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

            Object[] datos = {nombre,apellido,correo,fecha_entrada,ciudad,horas_semanales,especialidad,estado, correo_trabajo, comentarios};

            final int[] i = {0};

            if(!compararFechas(fecha_entrada,fecha_finalizacion))
            {
                return null;
            }

            columnas.forEach(columna ->
            {
                Object dato = datos[i[0]];

                if(dato.getClass().getTypeName().equalsIgnoreCase("STRING"))
                {
                    String comprobar = ((String) dato).trim();
                    if(comprobarString(comprobar))
                    {
                        predicates.add(cb.like(root.get(columna), "%" + comprobar + "%"));
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
        }
        return null;
    }

    private boolean comprobarString(String str)
    {
        if (str.length() != 0)
        {
            return true;
        }
        return false;
    }

    private boolean compararFechas(Date fecha1, Date fecha2)
    {
        if(fecha1.before(fecha2))
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
