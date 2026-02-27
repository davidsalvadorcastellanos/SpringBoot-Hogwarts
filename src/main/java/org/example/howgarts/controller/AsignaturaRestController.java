package org.example.howgarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.howgarts.service.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hogwarts/asignaturas")
@RequiredArgsConstructor
public class AsignaturaRestController {

    private final AsignaturaService asignaturaService;

    @Operation(summary = "Eliminar una asignatura")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(
            @Parameter(description = "ID de la asignatura a eliminar", example = "101")
            @PathVariable Long id) {

        try {
            asignaturaService.eliminarAsignatura(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
