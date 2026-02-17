package org.example.howgarts.mappers;

import org.example.howgarts.dto.MascotaDTO;
import org.example.howgarts.dto.create.MascotaCreateDTO;
import org.example.howgarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {

    public MascotaDTO toDto(Mascota mascota){
        if(mascota == null){
            return null;
        }
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getIdMascota());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiante(mascota.getEstudiante().getNombre());
        return dto;
    }

    public Mascota toEntity(MascotaCreateDTO mascotaCreateDTO){
        if(mascotaCreateDTO == null){
            return null;
        }
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaCreateDTO.getNombre());
        mascota.setEspecie(mascotaCreateDTO.getEspecie());
        return mascota;
    }
}
