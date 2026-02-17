package org.example.howgarts.dto;


import lombok.Data;

@Data
public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private String aula;
    private Boolean obligatoria;
    private String profesor;
}
