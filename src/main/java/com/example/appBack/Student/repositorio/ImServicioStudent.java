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

    private ArrayList<String> campos = new ArrayList<String>();

    @Override
    public ResponseEntity addStudent(StudentDTO sdto)
    {
        try {

        if(!compararFechas(sdto))
        {
            return ResponseEntity.ok("Fechas incorrectas");
        }

        if(studentRepository.existEmail(sdto))
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
        }
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
    public ResponseEntity deleteStudent(String id)
    {
        if(studentRepository.existsById(id)==true)
        {
           studentRepository.deleteById(id);
           return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity updateStudent(String id, StudentDTO sdto)
    {
        try {
        if(!studentRepository.existsById(id))
        {
            return ResponseEntity.status(401).build();
        }

        Student nuevoStudent = studentRepository.findById(id).get();
        nuevoStudent.setDatos(sdto);
        sdto = StudentDTO.getStudentDTO(nuevoStudent);

        if(!compararFechas(sdto))
        {
            return ResponseEntity.ok("Fechas incorrectas");
        }


        if(studentRepository.existEmail(sdto))
        {
            String compID = studentRepository.getStudentbyEmail(sdto).getId();
            if(!id.equalsIgnoreCase(compID))
            {
                return ResponseEntity.ok("ERROR Email Existente");
            }
        }


        if(studentRepository.existNameSurname(sdto))
        {
            String compID = studentRepository.getStudentbyNameSurname(sdto).getId();
            if(!id.equalsIgnoreCase(compID))
            {
                return ResponseEntity.ok("ERROR, nombre y apellidos repetidos");
            }
        }
            /*Student nuevoStudent = new Student(sdto);
            nuevoStudent.setId(id);
            studentRepository.saveAndFlush(nuevoStudent);*/



            studentRepository.saveAndFlush(nuevoStudent);

            return ResponseEntity.ok("Actualizado");

        }
        catch (Exception e)
        {
            return ResponseEntity.ok("VALOR NULL");
        }
    }

    @Override
    public List<StudentDTO> getConsultaCampo(StudentDTO aConsultar)
    {
        return studentRepository.getQuery(aConsultar);
    }

    private boolean compararFechas(StudentDTO sdto)
    {
        Date fecha1 = sdto.getFecha_entrada();
        Date fecha2 = sdto.getFecha_finalizacion();

        if(fecha1 == null || fecha2 == null)
        {
            return false;
        }
        return fecha1.before(fecha2);
    }
}
