package com.example.appBack.Tablas.Student.infrastructure.repositorio;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Excepciones.UpdateErrorException;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SaveCreateStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CreateStudentRepository implements SaveCreateStudentPort
{
    StudentRepository studentRepository;

    //FindProfesorRepository findProfesorRepository;

    @Override
    public Student addStudent(Student sdto) throws Exception
    {
        StudentJpa nuevoStudent = new StudentJpa(sdto);

        if(!sdto.compararFechas(sdto))
        {
            throw new UpdateErrorException("Fecha de alta superior a la de baja");
        }

        /*if(ComprobarNulos.comprobarString(sdto.getProfesor()) && !findProfesorRepository.existProfesor(sdto.getProfesor()))
        {
            throw new UpdateErrorException("Profesor inexistente");
        }*/

        if(!ComprobarNulos.comprobarString(sdto.getCorreo()))
        {
            throw new UpdateErrorException("Correo electronico personal pasado como valor nulo/vacío, ese tipo de valor no esta permitido para este campo");
        }

        if(!ComprobarNulos.comprobarString(sdto.getNombre()) && !ComprobarNulos.comprobarString(sdto.getApellido())){
            throw new UpdateErrorException("Nombre o apellidos pasado como valor vacío/nulo, estos campos deben tener valor asignado");
        }

        if(studentRepository.findByCorreo(sdto.getCorreo()).size() != 0)
        {
            throw new UpdateErrorException("Correo electronico personal ya existente");
        }

        if(studentRepository.findByNombreAndApellido(sdto.getNombre(),sdto.getApellido()).size() != 0){
            throw new UpdateErrorException("Nombre y apellidos repetidos");
         }

        studentRepository.saveAndFlush(nuevoStudent);
        return Student.getStudentDTO(nuevoStudent);
    }
}
