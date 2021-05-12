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
import com.example.appBack.Student.Entity.branch;

public class StudentRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;

    private CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    private CriteriaQuery<Student> query = cb.createQuery(Student.class);
    private Root<Student> root = query.from(Student.class);
    private List<Predicate> predicates = new ArrayList<>();

    private void resetQueries()
    {
        cb = entityManager.getCriteriaBuilder();
        query = cb.createQuery(Student.class);
        root = query.from(Student.class);
        predicates = new ArrayList<>();
    }

    public List<StudentDTO> getQuery(StudentDTO consulta)
    {
        try
        {
            resetQueries();

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
            Boolean estado = consulta.getEstado();
            branch branch= consulta.getBranch();


            if(comprobarString(nombre)){ predicates.add(cb.equal(root.get("nombre"), nombre));}
            if(comprobarString(apellido)){ predicates.add(cb.equal(root.get("apellido"), apellido));}
            if(comprobarString(correo)){ predicates.add(cb.equal(root.get("correo"), correo));}
            //if(comprobarFechas(fecha_entrada)){ predicates.add(cb.equal(root.get("fecha_entrada"), fecha_entrada));}

            //if(comprobarFechas(fecha_finalizacion)){ predicates.add(cb.equal(root.get("fecha_finalizacion"), fecha_finalizacion));}
            if(comprobarString(ciudad)){ predicates.add(cb.equal(root.get("ciudad"), ciudad));}
            if(comprobarString(especialidad)){ predicates.add(cb.equal(root.get("especialidad"), especialidad));}
            if(comprobarString(comentarios)){ predicates.add(cb.equal(root.get("comentarios"), comentarios));}

            if(comprobarString(correo_trabajo)){ predicates.add(cb.equal(root.get("correo_trabajo"), correo_trabajo));}
            if(comprobarNumbers(horas_semanales)){ predicates.add(cb.equal(root.get("horas_semanales"), horas_semanales));}
            if(comprobarObjects(estado)){ predicates.add(cb.equal(root.get("estado"), estado));}
            if(comprobarObjects(branch)){ predicates.add(cb.equal(root.get("branch"), branch));}

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

    private void addEquals(String nameColum, Object objeto)
    {
        if(comprobarObjects(objeto)) {
            if (comprobarString(objeto.toString())) {
                predicates.add(cb.equal(root.get(nameColum), objeto.toString()));
            } else {
                predicates.add(cb.equal(root.get(nameColum), objeto));
            }
        }
    }

    private void addLike(String nameColum, Object objeto)
    {

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
        catch (Exception e){e.printStackTrace();}
        return false;
    }

    private boolean comprobarString(String str)
    {
        try {
            if (str.trim().length() != 0 && str != null)
            {
                return true;
            }
        }catch (Exception e) {e.printStackTrace(); }
        return false;
    }

    private boolean comprobarObjects(Object objeto)
    {
        try {
            if (objeto != null) {
                if(comprobarString(objeto.toString())){
                    return true;}
                if(comprobarNumbers(objeto)){
                    return true;
                }
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
