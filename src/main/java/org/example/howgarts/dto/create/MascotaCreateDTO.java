package org.example.howgarts.dto.create;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MascotaCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 100, message = "Has superado el maximo de caracteres")
    private String nombre;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 100, message = "Has superado el maximo de caracteres")
    private String especie;
}
