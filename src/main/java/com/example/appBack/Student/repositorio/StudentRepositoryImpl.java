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

    public List<StudentDTO> getQueryEquals(StudentDTO consulta)
    {
        try
        {
            resetQueries();

            ArrayList<Object> datos1 = new ArrayList<>();
            datos1.add(consulta.getNombre());
            datos1.add(consulta.getApellido());
            datos1.add(consulta.getCorreo());
            datos1.add(consulta.getFecha_entrada());
            datos1.add(consulta.getFecha_finalizacion());
            datos1.add(consulta.getCiudad());
            datos1.add(consulta.getHoras_semanales());
            datos1.add(consulta.getEspecialidad());
            datos1.add(consulta.getCorreo_trabajo());
            datos1.add(consulta.getComentarios());
            datos1.add(consulta.getEstado());
            datos1.add(consulta.getBranch());


            ArrayList<String> datos = new ArrayList<>();
            datos.add("nombre");
            datos.add("apellido");
            datos.add("correo");
            datos.add("fecha_entrada");
            datos.add("fecha_finalizacion");
            datos.add("ciudad");
            datos.add("horas_semanales");
            datos.add("especialidad");
            datos.add("correo_trabajo");
            datos.add("comentarios");
            datos.add("estado");
            datos.add("branch");

            for(int i=0;i<datos.size();i++){
              addEquals(datos.get(i), datos1.get(i));
            }

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
                predicates.add(cb.equal(root.get(nameColum), objeto));
        }
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
