package org.example.howgarts.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "especie")
    private String especie;

    @Column(name = "id_estudiente")
    private Long idEstudiante;

}
