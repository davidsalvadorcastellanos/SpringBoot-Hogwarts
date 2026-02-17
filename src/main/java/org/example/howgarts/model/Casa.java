package org.example.howgarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long idCasa;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "fundador")
    private String fundador;

//    @Column(name = "id_jefe")
//    private Long idJefe;

//    @Column(name = "fantasma")
    private String fantasma;

    @OneToMany(mappedBy = "casa")
    @JsonBackReference
    private List<Estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    @JsonManagedReference
    private Profesor profesor;
}
