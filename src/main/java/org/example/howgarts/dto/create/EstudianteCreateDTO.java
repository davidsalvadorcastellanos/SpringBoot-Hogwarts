package org.example.howgarts.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 100, message = "Has superado el maximo de caracteres")
    private String nombre;

    @NotBlank(message = "Los apellidos no puede estar vacios")
    @Size(max = 100, message = "Has superado el maximo de caracteres")
    private String apellido;


    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El curso es obligatorio")
    @Min(value = 1, message = "El curso debe ser mínimo 1")
    @Max(value = 7, message = "El curso debe ser máximo 7")
    private Long anyoCurso;

    @NotNull(message = "El id de la casa es obligatorio")
    @Min(value = 1, message = "El id de casa debe ser como mínimo 1")
    @Max(value = 4, message = "El id de casa debe ser como máximo 4")
    private Long idCasa;

    @Valid
    @NotNull(message = "Debe de tener mascota")
    private MascotaCreateDTO mascota;
}
