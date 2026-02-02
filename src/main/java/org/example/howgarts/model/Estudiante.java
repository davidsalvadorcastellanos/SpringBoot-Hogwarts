package org.example.howgarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "apellido")
    private String apellido;

    @Column(name = "id_casa")
    private Long idCasa;

    @Column(name = "anyo_curso")
    private Long anyoCurso;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    // RELACIONES

    @OneToOne(mappedBy = "estudiante")
    @JsonBackReference
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    private List<Asignatura> asignaturas;
}
