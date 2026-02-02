package org.example.howgarts.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "apellido")
    private String apellido;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;
}
