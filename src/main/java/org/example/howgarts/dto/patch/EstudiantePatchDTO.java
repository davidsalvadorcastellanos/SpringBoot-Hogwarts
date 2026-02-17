package org.example.howgarts.dto.patch;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EstudiantePatchDTO {
    private String nombre;
    private String apellido;

    @Min(value = 1, message = "El año de curso debe ser al menos 1")
    private Long anyoCurso;

    private LocalDate fechaNacimiento;

    private Long idCasa;

    @Valid
    private MascotaPatchDTO mascota;
}