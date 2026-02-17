package org.example.howgarts.controller;


import jakarta.validation.Valid;
import org.example.howgarts.dto.EstudianteDTO;
import org.example.howgarts.dto.create.EstudianteCreateDTO;
import org.example.howgarts.dto.update.EstudianteUpdateDTO;
import org.example.howgarts.model.Estudiante;
import org.example.howgarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/estudiantes")
public class EstudianteRestController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteRestController (EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes(){
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if(estudiantes == null){
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(estudiantes); // 200 Ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id){
        EstudianteDTO estudianteDto = estudianteService.obtenerEstudiantePorId(id);
        if(estudianteDto == null){
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(estudianteDto); // 200 Ok
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO estudianteCreateDTO){
        EstudianteDTO estudianteDTO = estudianteService.crearEstudiante(estudianteCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteDTO); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(
            @PathVariable Long id,
            @Valid @RequestBody EstudianteUpdateDTO dto) {
        return ResponseEntity.ok(estudianteService.actualizarEstudianteCompleto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.borrarEstudiante(id);
        return ResponseEntity.noContent().build(); // Devuelve 204
    }
}
