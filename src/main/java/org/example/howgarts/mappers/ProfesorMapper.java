package org.example.howgarts.mappers;

import org.example.howgarts.dto.ProfesorDTO;
import org.example.howgarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {

    public ProfesorDTO toDto(Profesor profesor){
        if(profesor == null){
            return null;
        }
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getIdProfesor());
        dto.setNombre(profesor.getNombre());
        dto.setAsignatura(profesor.getAsignatura().getNombre());
        dto.setFechaInicio(profesor.getFechaInicio().toLocalDate());
        return dto;
    }
}
