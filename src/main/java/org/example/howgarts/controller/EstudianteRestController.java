package org.example.howgarts.controller;


import org.example.howgarts.model.Estudiante;
import org.example.howgarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes(){
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if(estudiantes == null){
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(estudiantes); // 200 Ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id){
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        if(estudiante == null){
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(estudiante); // 200 Ok
    }
}
