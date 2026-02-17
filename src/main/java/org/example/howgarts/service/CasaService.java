package org.example.howgarts.service;

import org.example.howgarts.dto.CasaDTO;

import java.util.List;

public interface CasaService {

    List<CasaDTO> obtenerTodasLasCasas();

    CasaDTO obtenerCasaPorId(Long id);
}
