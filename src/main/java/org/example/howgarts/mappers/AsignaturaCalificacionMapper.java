package org.example.howgarts.mappers;

import org.example.howgarts.dto.AsiganturaCalificacionDTO;
import org.example.howgarts.model.AsignaturaCalificacion;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaCalificacionMapper {

    public AsiganturaCalificacionDTO toDto(AsignaturaCalificacion asignaturaCalificacion) {
        if (asignaturaCalificacion == null) {
            return null;
        }
        AsiganturaCalificacionDTO dto = new AsiganturaCalificacionDTO();
        dto.setAsignatura(asignaturaCalificacion.getAsignatura().getNombre());
        dto.setCalificacion(asignaturaCalificacion.getNota());
        return dto;
    }
}
