package org.example.howgarts.model;

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
    private Long aula;

//    @Column(name = "obligatoria")
    private Boolean obligatoria;

    @OneToOne(mappedBy = "asignatura")
    private Profesor profesor;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;
}
