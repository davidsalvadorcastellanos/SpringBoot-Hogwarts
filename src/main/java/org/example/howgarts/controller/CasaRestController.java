package org.example.howgarts.controller;


import org.example.howgarts.dto.CasaDTO;
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
@RequestMapping("/hogwarts/casas")
public class CasaRestController {

    private final CasaService casaService;

    @Autowired
    public CasaRestController (CasaService casaService){
        this.casaService = casaService;
    }

    @GetMapping
    public ResponseEntity<List<CasaDTO>> obtenerTodasLasCasas(){
        List<CasaDTO> casasDto = casaService.obtenerTodasLasCasas();
        if(casasDto == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(casasDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaDTO> obtenerCasaPorId(@PathVariable Long id){
        CasaDTO casaDto = casaService.obtenerCasaPorId(id);
        if(casaDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casaDto);
    }
}
