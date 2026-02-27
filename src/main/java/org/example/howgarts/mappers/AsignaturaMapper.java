package org.example.howgarts.mappers;

import org.example.howgarts.dto.AsignaturaDTO;
import org.example.howgarts.model.Asignatura;
import org.example.howgarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public static AsignaturaDTO toDto(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getIdAsignatura());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());

        Profesor profesor = asignatura.getProfesor();

        if (profesor != null) {
            dto.setProfesor(profesor.getNombre() + " " + profesor.getApellido());
        }

        return dto;
    }
}

