package org.example.howgarts.services;

import org.example.howgarts.model.Estudiante;
import org.example.howgarts.repository.EstudianteRepository;
import org.example.howgarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteTestService {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombre("Harry");
        estudianteTest.setApellido("Potter");
    }

    @Test
    void borrar_Estudiante() {
        // GIVEN
        Long id = 1L;
        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        // WHEN
        estudianteService.borrarEstudiante(id);

        // THEN
        // Cambiamos deleteById por delete pasándole el objeto
        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }
}
