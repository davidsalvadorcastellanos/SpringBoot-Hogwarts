package org.example.howgarts.controller;


import org.example.howgarts.model.Casa;
import org.example.howgarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
public class CasaRestController {

    private final CasaService casaService;

    @Autowired
    public CasaRestController (CasaService casaService){
        this.casaService = casaService;
    }

    @GetMapping
    public ResponseEntity<List<Casa>> obtenerTodasLasCasas(){
        List<Casa> casas = casaService.obtenerTodasLasCasas();
        if(casas == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(casas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Casa> obtenerCasaPorId(@PathVariable Long id){
        Casa casa = casaService.obtenerCasaPorId(id);
        if(casa == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casa);
    }
}
