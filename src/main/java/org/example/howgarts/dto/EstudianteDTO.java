package org.example.howgarts.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private Long anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDTO mascota;
    private List<AsiganturaCalificacionDTO> asignaturas;
}
