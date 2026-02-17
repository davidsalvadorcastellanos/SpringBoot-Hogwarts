package org.example.howgarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long idAsignatura;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "aula")
    private String aula;

//    @Column(name = "obligatoria")
    private Boolean obligatoria;

    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura")
    private List<AsignaturaCalificacion> asignaturaCalificacions;
}
