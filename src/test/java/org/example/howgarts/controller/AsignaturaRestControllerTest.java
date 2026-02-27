package org.example.howgarts.controller;

import org.example.howgarts.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsignaturaRestController.class)
public class AsignaturaRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AsignaturaService asignaturaService;

    @Test
    void eliminarAsignatura_ConAlumnos_DebeRetornar409() throws Exception {
        // GIVEN
        doThrow(new IllegalStateException("La asignatura tiene alumnos"))
                .when(asignaturaService).eliminarAsignatura(1L);

        mockMvc.perform(delete("/hogwarts/asignaturas/1"))
                .andExpect(status().isConflict());
    }
}