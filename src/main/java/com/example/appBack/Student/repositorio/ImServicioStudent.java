package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ImServicioStudent implements ServicioStudent
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity addStudent(StudentDTO sdto)
    {
        Student nuevoStudent = new Student(sdto);
        studentRepository.saveAndFlush(nuevoStudent);

        return ResponseEntity.ok().build();
    }

    @Override
    public StudentDTO getStudent(int id)
    {
        Optional<Student> estudiante = studentRepository.findById(id);
        if(!estudiante.isEmpty())
        {
            return StudentDTO.getDTO(estudiante.get());
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
    public ResponseEntity deleteStudent(int id) {
        ResponseEntity respuesta=null;
        if(studentRepository.existsById(id)==true){
           studentRepository.deleteById(id);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity updateStudent(int id, StudentDTO sdto)
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
        return studentRepository.getQuery(aConsultar);
    }

    @Override
    public Student getCompararValores(Optional<StudentDTO> insertado, ArrayList<String> columnas)
    {
        String id = "";

        StudentDTO comprobar = new StudentDTO();

        StudentDTO insertar = new StudentDTO();

        if(insertado.isEmpty())
        {
            return null;
        }
        else
        {
            insertar = insertado.get();
        }

        if(columnas.isEmpty()){return null;}

        if(columnas.get(0).equalsIgnoreCase("id"))
        {
            id = columnas.get(1);
            for(int i =0; i != 2; i++)
            {
                columnas.remove(0);
            }
        }
        try {
            if (columnas.get(0).equalsIgnoreCase("borrar")) {
                int fin = Integer.parseInt(columnas.get(1));//cuantos campos no quieress cnsultar
                int posicion = Integer.parseInt(columnas.get(2));//a partir de que campo no quieres consultar
                for (int i = 0; i != 3; i++) {
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
            String nombre = insertar.getNombre();
            String apellido = insertar.getApellido();
            String correo = insertar.getCorreo();
            Date fecha_entrada = insertar.getFecha_entrada();
            String ciudad = insertar.getCiudad();
            Integer horas_semanales = insertar.getHoras_semanales();
            String especialidad = insertar.getEspecialidad();
            String estado = insertar.getEstado();

            columnas.forEach(columna ->
            {
                switch (columna)
                {
                    case ("nombre"):
                        break;
                    /**if (isStringNull(nombre))
                    {
                        comprobar.setNombre(nombre);
                    }

                    if (isStringNull(apellido))
                    {
                        comprobar.setApellido(apellido);
                    }

                    if (isStringNull(correo))
                    {
                        comprobar.setCorreo(correo);
                    }

                    if (isNull(fecha_entrada))
                    {
                        comprobar.setFecha_entrada(fecha_entrada);
                    }

                    if (isStringNull(ciudad))
                    {
                        comprobar.setCiudad(ciudad);
                    }

                    if (isNull(horas_semanales))
                    {
                        comprobar.setHoras_semanales(horas_semanales);
                    }

                    if (isStringNull(especialidad))
                    {
                        comprobar.setEspecialidad(especialidad);
                    }

                    if (isStringNull(estado))
                    {
                        comprobar.setEstado(estado);
                    }*/
                }

            });

            List recogida = studentRepository.getQuery(comprobar);
            if(!recogida.isEmpty())
            {
                //return true;
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
        }
        //return false;
        return null;
    }

    @Override
    public ArrayList<String> getAllColums()
    {
        return null;
    }

    @Override
    public ArrayList<String> getAllColums(String id) {
        return null;
    }

    @Override
    public ArrayList<String> getColum(String numCampos, String posicionPrimerCampo) {
        return null;
    }

    @Override
    public ArrayList<String> getColum(String id, String numCampos, String posicionPrimerCampo) {
        return null;
    }

    /**private boolean isStringNull(String str)
    {
        if (str != null && str.trim().length() != 0)
        {
            return false;
        }
        return true;
    }

    private boolean isNull(Object str)
    {
        if (str != null)
        {
            return false;
        }
        return true;
    }*/
}
