package org.example.howgarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    // RELACIONES

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonBackReference
    private Estudiante estudiante;

}
