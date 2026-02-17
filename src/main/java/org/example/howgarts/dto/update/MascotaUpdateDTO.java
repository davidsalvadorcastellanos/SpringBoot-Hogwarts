package org.example.howgarts.dto.update;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MascotaUpdateDTO {
    @NotBlank(message = "El nombre de la mascota es obligatorio")
    private String nombre;

    @NotBlank(message = "La especie de la mascota es obligatoria")
    private String especie;
}