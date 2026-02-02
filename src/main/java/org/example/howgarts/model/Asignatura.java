package org.example.howgarts.model;

import jakarta.persistence.*;
import lombok.Data;

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


}
