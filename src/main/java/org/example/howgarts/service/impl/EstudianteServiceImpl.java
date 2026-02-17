package org.example.howgarts.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.howgarts.dto.EstudianteDTO;
import org.example.howgarts.dto.create.EstudianteCreateDTO;
import org.example.howgarts.dto.update.EstudianteUpdateDTO;
import org.example.howgarts.mappers.EstudianteMapper;
import org.example.howgarts.model.Estudiante;
import org.example.howgarts.repository.EstudianteRepository;
import org.example.howgarts.service.EstudianteService;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toDto)
                .toList();
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante con id " + id + " no encontrado"));
        return estudianteMapper.toDto(estudiante);
    }

    @Override
    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto){
        Estudiante estudiante = estudianteMapper.toEntity(dto);

        if (estudiante.getMascota() != null) {
            estudiante.getMascota().setEstudiante(estudiante);
        }

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDto(estudianteGuardado);
    }

    @Override
    @Transactional
    public EstudianteDTO actualizarEstudianteCompleto(Long id, EstudianteUpdateDTO dto) {
        Estudiante estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));

        estudianteMapper.updateEntityFromUpdateDto(dto, estudianteExistente);

        Estudiante actualizado = estudianteRepository.save(estudianteExistente);

        return estudianteMapper.toDto(actualizado);
    }

    @Override
    @Transactional
    public void borrarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se puede borrar: Estudiante con id " + id + " no encontrado"));

        estudianteRepository.delete(estudiante);
    }
}
