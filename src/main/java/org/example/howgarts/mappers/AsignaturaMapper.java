package org.example.howgarts.mappers;

import org.example.howgarts.dto.AsignaturaDTO;
import org.example.howgarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO toDto(Asignatura asignatura){
        if(asignatura == null){
            return null;
        }
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getIdAsignatura());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());
        dto.setProfesor(asignatura.getProfesor().getNombre());
        return dto;
    }
}
