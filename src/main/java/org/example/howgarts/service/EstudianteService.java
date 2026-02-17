package org.example.howgarts.service;

import org.example.howgarts.dto.EstudianteDTO;
import org.example.howgarts.dto.create.EstudianteCreateDTO;
import org.example.howgarts.dto.update.EstudianteUpdateDTO;
import org.example.howgarts.model.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    EstudianteDTO obtenerEstudiantePorId(Long id);

    EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);

    EstudianteDTO actualizarEstudianteCompleto(Long id, EstudianteUpdateDTO dto);

    void borrarEstudiante(Long id);
}
