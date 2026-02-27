package org.example.howgarts.service.impl;

import org.example.howgarts.model.Asignatura;
import org.example.howgarts.repository.AsignaturaRepository;
import org.example.howgarts.service.AsignaturaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    @Override
    public void eliminarAsignatura(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("La asignatura con ID " + id + " no existe."));

        if (asignatura.getAsignaturaCalificacions() != null && !asignatura.getAsignaturaCalificacions().isEmpty()) {
            throw new IllegalStateException("Tiene alumnos");
        }

        // 3. Si no tiene a nadie, se borra normal
        asignaturaRepository.deleteById(id);
    }
}