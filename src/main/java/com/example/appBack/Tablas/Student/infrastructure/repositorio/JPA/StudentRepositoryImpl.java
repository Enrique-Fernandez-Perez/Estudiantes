package com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;

    private CriteriaBuilder cb ;
    private CriteriaQuery<StudentJpa> query;
    private Root<StudentJpa> root;
    private List<Predicate> predicates;


    private void resetQueries()
    {
        cb = entityManager.getCriteriaBuilder();
        query = cb.createQuery(StudentJpa.class);
        root = query.from(StudentJpa.class);
        predicates = new ArrayList<>();
    }

    public List<StudentJpa> getQueryLike(Student consulta)
    {
        try
        {
            resetQueries();

            ArrayList<Object> datosIntroducidos = new ArrayList<>();
            datosIntroducidos.add(consulta.getNombre());
            datosIntroducidos.add(consulta.getApellido());
            datosIntroducidos.add(consulta.getCorreo());
            datosIntroducidos.add(consulta.getFecha_entrada());
            datosIntroducidos.add(consulta.getFecha_finalizacion());
            datosIntroducidos.add(consulta.getCiudad());
            datosIntroducidos.add(consulta.getHoras_semanales());
            datosIntroducidos.add(consulta.getEspecialidad());
            datosIntroducidos.add(consulta.getCorreo_trabajo());
            datosIntroducidos.add(consulta.getComentarios());
            datosIntroducidos.add(consulta.getEstado());
            datosIntroducidos.add(consulta.getBranch());
            datosIntroducidos.add(consulta.getProfesor());


            ArrayList<String> nombreColumnas = new ArrayList<>();
            nombreColumnas.add("nombre");
            nombreColumnas.add("apellido");
            nombreColumnas.add("correo");
            nombreColumnas.add("fecha_entrada");
            nombreColumnas.add("fecha_finalizacion");
            nombreColumnas.add("ciudad");
            nombreColumnas.add("horas_semanales");
            nombreColumnas.add("especialidad");
            nombreColumnas.add("correo_trabajo");
            nombreColumnas.add("comentarios");
            nombreColumnas.add("estado");
            nombreColumnas.add("branch");
            nombreColumnas.add("Profesor");

            for(int i=0;i<nombreColumnas.size();i++){
              addLike(nombreColumnas.get(i), datosIntroducidos.get(i));
            }

            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            List<StudentJpa> lista = new ArrayList<>();
            lista.addAll(entityManager.createQuery(query).getResultList());
            return lista;
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
            return new ArrayList<>();
        }
    }

    private void addLike(String nameColum, Object objeto)
    {
        if(ComprobarNulos.comprobarObjects(objeto)) {
            if(ComprobarNulos.comprobarDistincString(objeto)){
                predicates.add(cb.equal(root.get(nameColum), objeto));
                return;
            }
            if(ComprobarNulos.comprobarString((String)objeto)){
                predicates.add(cb.like(cb.lower(root.get(nameColum)), "%"+ objeto.toString().toLowerCase() +"%"));
            }
            /**else{
                predicates.add(cb.equal(root.get(nameColum),objeto));
            }*/
        }

    }

    /*private boolean comprobarNumbers(Object num)
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
    }*/

    /*private boolean comprobarString(String str)
    {
        try {
            if (str.trim().length() != 0)
            {
                return true;
            }
        }catch (Exception e) {}
        return false;
    }*/

    /*private boolean comprobarObjects(Object objeto)
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
    }*/
}
