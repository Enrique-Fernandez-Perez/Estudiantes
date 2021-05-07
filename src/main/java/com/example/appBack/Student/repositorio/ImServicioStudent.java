package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Component
public class ImServicioStudent implements ServicioStudent
{
    @Autowired
    StudentRepository studentRepository;

    private ArrayList<String> campos = new ArrayList<String>();

    @Override
    public ResponseEntity addStudent(StudentDTO sdto)
    {
        Student nuevoStudent = new Student(sdto);
        studentRepository.saveAndFlush(nuevoStudent);

        return ResponseEntity.ok().build();
    }

    @Override
    public StudentDTO getStudent(String id)
    {
        Optional<Student> estudiante = studentRepository.findById(id);
        if(!estudiante.isEmpty())
        {
            return StudentDTO.getStudentDTO(estudiante.get());
        }

        return null;
    }

    @Override
    public List<StudentDTO> getAll()
    {
        List<Student> lista = studentRepository.findAll();
        if(lista.isEmpty())
        {
            return null;
        }
        else
        {
            return  StudentDTO.getAllDTO(lista);
        }
    }

    @Override
    public ResponseEntity deleteStudent(String id) {
        ResponseEntity respuesta=null;
        if(studentRepository.existsById(id)==true){
           studentRepository.deleteById(id);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity updateStudent(String id, StudentDTO sdto)
    {
        if(studentRepository.existsById(id)==true)
        {
            Student student = studentRepository.findById(id).get();
            try
            {
                student.setNombre(sdto.getNombre());
                student.setApellido(sdto.getApellido());
                student.setCorreo(sdto.getCorreo());
                student.setFecha_entrada(sdto.getFecha_entrada());
                student.setCiudad(sdto.getCiudad());
                student.setHoras_semanales(sdto.getHoras_semanales());
                student.setEspecialidad(sdto.getEspecialidad());
                student.setEstado(sdto.getEstado());
            }
            catch (Exception e){System.err.println(e.getMessage());}

            studentRepository.saveAndFlush(student);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<StudentDTO> getConsulaCampo(StudentDTO aConsultar)
    {
        return studentRepository.getQuery(aConsultar, getAllColums());
    }

    @Override
    public List<StudentDTO> getCompararValores(StudentDTO insertado, ArrayList<String> columnas)
    {
        String id = "";

        if(columnas.isEmpty()){return null;}

        if(columnas.get(0).equalsIgnoreCase("id"))
        {
            id = columnas.get(1);
            for(int i =0; i != 2; i++)
            {
                columnas.remove(0);
            }
            if(comprobarString(id))
            {
                Optional<Student> st = studentRepository.findById(id);
                if(st.isEmpty())
                {
                    return null;
                }
            }
        }

        try
        {
            if (columnas.get(0).equalsIgnoreCase("borrar"))
            {
                int fin = Integer.parseInt(columnas.get(1));//cuantos campos no quieress cnsultar
                int posicion = Integer.parseInt(columnas.get(2));//a partir de que campo no quieres consultar
                for (int i = 0; i != 3; i++)
                {
                    columnas.remove(0);
                }
                for (int i = 0; i != fin; i++) {
                    columnas.remove(posicion);
                }
            }
        }
        catch (Exception e)
        {
            System.err.println(""+e.getMessage());
            System.err.println(""+e.getCause());
        }

        try
        {
            List<StudentDTO> recogida = studentRepository.getQuery(insertado, columnas);
            return recogida;
        }
        catch (Exception e)
        {
            System.err.println(""+e.getMessage());
            System.err.println(""+e.getCause());
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllColums()
    {
        ArrayList<String> campos2 = new ArrayList<>();

        campos2.add("nombre");
        campos2.add("apellido");
        campos2.add("correo");
        campos2.add("fecha_entrada");
        campos2.add("ciudad");
        campos2.add("horas_semanales");
        campos2.add("especialidad");
        campos2.add("estado");
        campos2.add("correo_trabajo");
        campos2.add("comentarios");
        campos2.add("fecha_finalizacion");

        return campos2;
    }

    @Override
    public ArrayList<String> getAllColums(String id)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("id");
        campos.add(id);

        campos.addAll(getAllColums());

        return campos;
    }

    @Override
    public ArrayList<String> getColum(Integer numCampos, Integer posicionPrimerCampo)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("borrar");
        campos.add(""+numCampos);
        campos.add(""+posicionPrimerCampo);

        campos.addAll(getAllColums());

        return campos;
    }

    @Override
    public ArrayList<String> getColum(String id, Integer numCampos, Integer posicionPrimerCampo)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("id");
        campos.add(id);

        campos.add("borrar");
        campos.add(""+numCampos);
        campos.add(""+posicionPrimerCampo);

        campos.addAll(getAllColums());

        return campos;
    }

    private boolean comprobarString(String str)
    {
        if (str.length() != 0)
        {
            return true;
        }
        return false;
    }
}
