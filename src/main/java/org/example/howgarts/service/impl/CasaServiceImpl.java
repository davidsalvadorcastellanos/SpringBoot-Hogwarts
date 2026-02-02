package org.example.howgarts.service.impl;

import org.example.howgarts.model.Casa;
import org.example.howgarts.repository.CasaRepository;
import org.example.howgarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl implements CasaService {

    private final CasaRepository casaRepository;

    @Autowired
    public CasaServiceImpl (CasaRepository casaRepository){
        this.casaRepository = casaRepository;
    }

    @Override
    public List<Casa> obtenerTodasLasCasas(){
        return casaRepository.findAll();
    }

    @Override
    public Casa obtenerCasaPorId(Long id){
        return casaRepository.findById(id).orElse(null);
    }
}
