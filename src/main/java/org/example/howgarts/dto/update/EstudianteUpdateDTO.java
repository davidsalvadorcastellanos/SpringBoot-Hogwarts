package org.example.howgarts.dto.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EstudianteUpdateDTO {

    @NotNull(message = "El año de curso es obligatorio")
    @Min(value = 1, message = "El año de curso debe ser al menos 1")
    private Long anyoCurso;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @Valid
    private MascotaUpdateDTO mascota;
}