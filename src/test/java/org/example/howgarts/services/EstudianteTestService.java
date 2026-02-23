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

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Inicializa Mockito sin cargar Spring
class EstudianteTestService {

    @Mock // Crea un objeto simulado EstudianteRepository vacío
    private EstudianteRepository estudianteRepository;

    @InjectMocks // Crea la instancia del servicio e inyecta los mocks dentro
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombre("usuario_test");
    }

    @Test
    void eliminarEstudiante_Exito() {
        // GIVEN (Preparación)
        Long id = 1L;
        // Simulamos que el usuario existe y su lista de cuentas está vacía
        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        // WHEN (Ejecución)
        estudianteService.borrarEstudiante(id);

        // THEN (Verificación)
        // Verificamos que se llamó al método delete del repositorio exactamente una vez
        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }
}
