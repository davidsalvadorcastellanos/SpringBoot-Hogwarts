package org.example.howgarts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.howgarts.dto.CasaDTO;
import org.example.howgarts.mappers.CasaMapper;
import org.example.howgarts.model.Casa;
import org.example.howgarts.repository.CasaRepository;
import org.example.howgarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CasaServiceImpl implements CasaService {

    private final CasaRepository casaRepository;
    private final CasaMapper casaMapper;

    @Override
    public List<CasaDTO> obtenerTodasLasCasas(){
        return casaRepository.findAll()
                .stream()
                .map(casaMapper::toDto)
                .toList();
    }

    @Override
    public CasaDTO obtenerCasaPorId(Long id){
        Casa casa = casaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Casa con id " + id + " no encontrada"));
        return casaMapper.toDto(casa);
    }
}
