package org.example.howgarts.service.impl;

import org.example.howgarts.model.Estudiante;
import org.example.howgarts.repository.EstudianteRepository;
import org.example.howgarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes(){
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }
}
