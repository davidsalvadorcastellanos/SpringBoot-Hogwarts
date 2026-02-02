package org.example.howgarts.service;

import org.example.howgarts.model.Casa;

import java.util.List;

public interface CasaService {

    List<Casa> obtenerTodasLasCasas();

    Casa obtenerCasaPorId(Long id);
}
