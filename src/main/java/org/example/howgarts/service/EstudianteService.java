package org.example.howgarts.service;

import org.example.howgarts.model.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> obtenerTodosLosEstudiantes();

    Estudiante obtenerEstudiantePorId(Long id);
}
