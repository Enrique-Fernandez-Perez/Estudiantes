package com.example.appBack.Student.repositorio;

import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.RecursiveTask;

@Component
public class ImServicioStudent implements ServicioStudent
{
    @Autowired
    StudentRepository studentRepository;

    private ArrayList<String> campos = new ArrayList<String>();

    @Override
    public Student addStudent(StudentDTO sdto)
    {
        /**try {

        if(!compararFechas(sdto))
        {
            return ResponseEntity.ok("Fechas incorrectas");
        }

        /** if(studentRepository.existEmail(sdto))
        {
            return ResponseEntity.ok("ERROR Email Existente");
        }

        if(studentRepository.existNameSurname(sdto)){
            return ResponseEntity.ok("ERROR, nombre y apellidos repetidos");
        }

            Student nuevoStudent = new Student(sdto);
            studentRepository.saveAndFlush(nuevoStudent);

            return ResponseEntity.ok("Insertado");
        }
        catch (Exception e)
        {
            return ResponseEntity.ok("VALOR NULL");
        }*/
        return null;
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
            return StudentDTO.getAllDTO(lista);
        }
    }

    @Override
    public StudentDTO deleteStudent(String id)
    {
        if(studentRepository.existsById(id)==true) {
            studentRepository.deleteById(id);
            Student student = studentRepository.getOne(id);
            return StudentDTO.getStudentDTO(student);
        }
        return null;
    }

    @Override
    public Student updateStudent(String id, StudentDTO sdto)
    {
        /*try {
        if(!studentRepository.existsById(id))
        {
            return ResponseEntity.status(401).body("ID de Estudiante inexistente/no encontrado");
        }

        Student nuevoStudent = studentRepository.findById(id).get();
        nuevoStudent.setDatos(sdto);
        sdto = StudentDTO.getStudentDTO(nuevoStudent);

        if(!compararFechas(sdto))
        {
            return ResponseEntity.badRequest().body("Fechas de alta superior a la de baja");
        }


        if(studentRepository.existEmail(sdto))
        {
            String compID = studentRepository.getStudentbyEmail(sdto).getId();
            if(!id.equalsIgnoreCase(compID))
            {
                return ResponseEntity.badRequest().body("ERROR Email Existente");
            }
        }


        if(studentRepository.existNameSurname(sdto))
        {
            String compID = studentRepository.getStudentbyNameSurname(sdto).getId();
            if(!id.equalsIgnoreCase(compID))
            {
                return ResponseEntity.badRequest().body("ERROR, nombre y apellidos repetidos");
            }
        }

            /*studentRepository.saveAndFlush(nuevoStudent);

                return nuevoStudent;

        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("ALGUN VALOR INTRODUCIDO ES NULO, NO SE ACEPTAN NULOS");
        }*/
        return null;
    }

    @Override
    public List<StudentDTO> getConsultaCampo(StudentDTO aConsultar)
    {
        //return studentRepository.getQuery(aConsultar);
        return null;
    }

    private boolean compararFechas(StudentDTO sdto)
    {
        try{
            Date fecha1 = sdto.getFecha_entrada();
            Date fecha2 = sdto.getFecha_finalizacion();

            if(fecha1 != null && fecha2 == null){
                return true;
            }
            if(fecha1 != null && fecha2 != null){
                return fecha1.before(fecha2);
            }

            return fecha1.before(fecha2);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
