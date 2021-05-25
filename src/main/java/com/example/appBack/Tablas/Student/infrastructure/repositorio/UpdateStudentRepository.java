package com.example.appBack.Tablas.Student.infrastructure.repositorio;

import com.example.appBack.Comprobadores.ComprobarNulos;
import com.example.appBack.Excepciones.NotFoundException;
import com.example.appBack.Excepciones.UpdateErrorException;
import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.port.SaveUpdateStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

//Todo findProfesor

@AllArgsConstructor
@Repository
public class UpdateStudentRepository implements SaveUpdateStudentPort
{
    StudentRepository studentRepository;

    //FindProfesorRepository findProfesorRepository;

    @Override
    public Student updateStudent(String id, Student sdto) throws UpdateErrorException {
        return Student.getStudentDTO(studentRepository.findById(id).map(estudiante -> {
            studentRepository.findById(id).orElseThrow(()->new NotFoundException("Estudiante no existente"));

            if(!sdto.compararFechas(sdto))
            {
                throw new UpdateErrorException("Fecha de alta superior a la de baja");
            }

            /*if(ComprobarNulos.comprobarString(sdto.getProfesor()) && !findProfesorRepository.existProfesor(sdto.getProfesor()))
            {
                throw new UpdateErrorException("Profesor inexistente");
            }*/

            if(!ComprobarNulos.comprobarObjects(sdto.getCorreo()))
            {
                throw new UpdateErrorException("Correo electronico personal pasado como valor nulo, ese tipo de valor no esta permitido para este campo");
            }

            if(!ComprobarNulos.comprobarObjects(sdto.getNombre()) && !ComprobarNulos.comprobarObjects(sdto.getApellido())){
                throw new UpdateErrorException("Nombre o apellidos pasado como valor nulo, ese tipo de valor no esta permitido para este campo");
            }

            if(studentRepository.findByCorreo(sdto.getCorreo()).size() != 0)
            {
                if(!Student.getStudentDTO(studentRepository.findByCorreo(sdto.getCorreo()).get(0)).getId().equalsIgnoreCase(id)){
                    throw new UpdateErrorException("Correo electronico personal ya existente");
                }
            }

            if(studentRepository.findByNombreAndApellido(sdto.getNombre(),sdto.getApellido()).size() != 0){
                if(!comprobarNombreApellidos(id,sdto.getNombre(),sdto.getApellido())){
                    throw new UpdateErrorException("Nombre y apellidos repetidos");
                }
            }

            estudiante.setDatos(sdto);

            studentRepository.save(estudiante);

            return estudiante;
        }
        ).orElseThrow(() -> new UpdateErrorException("Error al actualizar un estudiante.")));
    }

    private boolean comprobarNombreApellidos(String id, String nombre, String apellido)
    {
        Student student = Student.getStudentDTO(studentRepository.findByNombreAndApellido(nombre,apellido).get(0));
        if(student.getId().equalsIgnoreCase(id)){
            return true;
        }
        return false;
    }
}
