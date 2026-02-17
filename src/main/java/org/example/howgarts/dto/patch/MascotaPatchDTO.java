package org.example.howgarts.dto.patch;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MascotaPatchDTO {
    @Size(max = 50, message = "El nombre de la mascota debe tener entre 2 y 50 caracteres")
    private String nombre;

    private String especie;
}