package org.example.howgarts.mappers;

import org.example.howgarts.dto.AsiganturaCalificacionDTO;
import org.example.howgarts.dto.EstudianteDTO;
import org.example.howgarts.dto.create.EstudianteCreateDTO;
import org.example.howgarts.dto.update.EstudianteUpdateDTO;
import org.example.howgarts.model.Casa;
import org.example.howgarts.model.Estudiante;
import org.example.howgarts.model.Mascota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudianteMapper {

    private final MascotaMapper mascotaMapper;

    public EstudianteMapper(MascotaMapper mascotaMapper){
        this.mascotaMapper = mascotaMapper;
    }

    public EstudianteDTO toDto(Estudiante estudiante){
        if(estudiante == null){
            return null;
        }
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setCasa(estudiante.getCasa().getNombre());
        dto.setMascota(mascotaMapper.toDto(estudiante.getMascota()));
        List<AsiganturaCalificacionDTO> listaDtos = List.of();
        if (estudiante.getAsignaturaCalificacions() != null) {
            listaDtos = estudiante.getAsignaturaCalificacions().stream()
                    .map(calificacion -> {
                        AsiganturaCalificacionDTO dtoo = new AsiganturaCalificacionDTO();
                        if (calificacion.getAsignatura() != null) {
                            dtoo.setAsignatura(calificacion.getAsignatura().getNombre());
                        }
                        dtoo.setCalificacion(calificacion.getNota());
                        return dtoo;
                    }).toList();
        }

        dto.setAsignaturas(listaDtos);

        return dto;
    }

    public Estudiante toEntity(EstudianteCreateDTO estudianteDto){
        if(estudianteDto == null){
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDto.getNombre());
        estudiante.setApellido(estudianteDto.getApellido());
        estudiante.setAnyoCurso(estudianteDto.getAnyoCurso());
        estudiante.setFechaNacimiento(estudianteDto.getFechaNacimiento());
        if (estudianteDto.getIdCasa() != null) {
            Casa casa = new Casa();
            casa.setIdCasa(estudianteDto.getIdCasa());

            switch (estudianteDto.getIdCasa().intValue()) {
                case 1 -> casa.setNombre("Gryffindor");
                case 2 -> casa.setNombre("Hufflepuff");
                case 3 -> casa.setNombre("Ravenclaw");
                case 4 -> casa.setNombre("Slytherin");
            }

            estudiante.setCasa(casa);
        }
        estudiante.setMascota(mascotaMapper.toEntity(estudianteDto.getMascota()));
        return estudiante;
    }

    public void updateEntityFromUpdateDto(EstudianteUpdateDTO dto, Estudiante estudiante) {
        if (dto == null) return;

        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        if (dto.getMascota() == null) {
            estudiante.setMascota(null);
        } else {
            // Si ya tenía mascota, la actualizamos. Si no, creamos una nueva.
            if (estudiante.getMascota() == null) {
                estudiante.setMascota(new Mascota());
            }
            estudiante.getMascota().setNombre(dto.getMascota().getNombre());
            estudiante.getMascota().setEspecie(dto.getMascota().getEspecie());
            estudiante.getMascota().setEstudiante(estudiante);
        }
    }
}
