package org.example.howgarts.mappers;


import org.example.howgarts.dto.CasaDTO;
import org.example.howgarts.model.Casa;
import org.springframework.stereotype.Component;

@Component
public class CasaMapper {

    private final ProfesorMapper profesorMapper;

    public CasaMapper(ProfesorMapper profesorMapper){
        this.profesorMapper = profesorMapper;
    }

    public CasaDTO toDto(Casa casa){

        if(casa == null){
            return null;
        }
        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getIdCasa());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());
        dto.setJefe(profesorMapper.toDto(casa.getProfesor()));
        dto.setEstudiantes(casa.getEstudiantes() != null
                            ? casa.getEstudiantes().stream()
                            .map(t -> "Nombre: " + t.getNombre() + ", Apellidos: " + t.getApellido())
                            .toList()
                : null);
        return dto;
    }
}
