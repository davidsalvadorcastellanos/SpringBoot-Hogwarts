package org.example.howgarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String nombre;

    private String apellido;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @OneToOne(mappedBy = "profesor")
    @JsonBackReference
    private Casa casa;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonManagedReference
    private Asignatura asignatura;
}
