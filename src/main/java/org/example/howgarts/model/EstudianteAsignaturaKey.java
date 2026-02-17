package org.example.howgarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class EstudianteAsignaturaKey implements Serializable {

    @Column(name = "id_estudiante")
    Long idEstudiante;

    @Column(name = "id_asignatura")
    Long idAsignatura;
}
