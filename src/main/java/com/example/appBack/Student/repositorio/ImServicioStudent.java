package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
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
    private StudentDTO comprobar = new StudentDTO();

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

        this.comprobar = new StudentDTO();

        StudentDTO insertar = new StudentDTO();

        Student devolver;// = new Student();

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

            Optional<Student> st = studentRepository.findById(0);
            if(!st.isEmpty())
            {
                this.comprobar = StudentDTO.getDTO(st.get());
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
                switch (columna) {
                    case ("nombre"):
                        if (comprobarString(nombre))
                        {
                            this.comprobar.setNombre(nombre);
                        }
                        break;
                    case ("apellido"):
                        if (comprobarString(apellido)) {
                            this.comprobar.setApellido(apellido);
                        }
                        break;
                    case ("correo"):
                        if (comprobarString(correo)) {
                            this.comprobar.setCorreo(correo);
                        }
                        break;
                    case ("fecha_entrada"):
                        if (compararFechas(fecha_entrada, fecha_entrada))
                        {
                            this.comprobar.setFecha_entrada(fecha_entrada);
                        }
                        else
                        {
                            return;
                        }
                        break;
                    case ("ciudad"):
                        if (comprobarString(ciudad)) {
                            this.comprobar.setCiudad(ciudad);
                        }
                        break;
                    case ("horas_semanales"):
                        if (comprobarNumbers(horas_semanales)) {
                            this.comprobar.setHoras_semanales(horas_semanales);
                        }
                        break;
                    case ("especialidad"):
                        if (comprobarString(especialidad)) {
                            this.comprobar.setEspecialidad(especialidad);
                        }
                        break;
                    case ("estado"):
                        if (comprobarString(estado)) {
                            this.comprobar.setEspecialidad(estado);
                        }
                        break;
                }
            });

            devolver = new Student(this.comprobar);
            if(comprobarString(id))
            {
                devolver.setId(id);
                return devolver;
            }

            List<StudentDTO> recogida = studentRepository.getQuery(this.comprobar);
            if(!recogida.isEmpty())
            {
                devolver = new Student(recogida.get(0));
                //return true;
            }
            else
            {
                return null;
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+"");
            return null;
        }
        //return false;
        return devolver;
    }

    @Override
    public ArrayList<String> getAllColums()
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("nombre");
        campos.add("apellido");
        campos.add("correo");
        campos.add("fecha_entrada");
        campos.add("ciudad");
        campos.add("horas_semanales");
        campos.add("especialidad");
        campos.add("estado");

        return campos;
    }

    @Override
    public ArrayList<String> getAllColums(String id)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("id");
        campos.add(id);

        campos.add("nombre");
        campos.add("apellido");
        campos.add("correo");
        campos.add("fecha_entrada");
        campos.add("ciudad");
        campos.add("horas_semanales");
        campos.add("especialidad");
        campos.add("estado");

        return campos;
    }

    @Override
    public ArrayList<String> getColum(String numCampos, String posicionPrimerCampo)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("borrar");
        campos.add(numCampos);
        campos.add(posicionPrimerCampo);

        campos.add("nombre");
        campos.add("apellido");
        campos.add("correo");
        campos.add("fecha_entrada");
        campos.add("ciudad");
        campos.add("horas_semanales");
        campos.add("especialidad");
        campos.add("estado");

        return campos;
    }

    @Override
    public ArrayList<String> getColum(String id, String numCampos, String posicionPrimerCampo)
    {
        campos.clear();
        campos.removeAll(campos);

        campos.add("id");
        campos.add(id);

        campos.add("borrar");
        campos.add(numCampos);
        campos.add(posicionPrimerCampo);

        campos.add("nombre");
        campos.add("apellido");
        campos.add("correo");
        campos.add("fecha_entrada");
        campos.add("ciudad");
        campos.add("horas_semanales");
        campos.add("especialidad");
        campos.add("estado");

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

    private boolean compararFechas(Date fecha1, Date fecha2)
    {
        return false;
    }

    private boolean comprobarNumbers(Number num)
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
