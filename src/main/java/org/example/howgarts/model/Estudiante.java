package org.example.howgarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
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

//    @Column(name = "id_casa")
//    private Long idCasa;

    @Column(name = "anyo_curso")
    private Long anyoCurso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // RELACIONES

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    @JsonManagedReference
    private Casa casa;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AsignaturaCalificacion> asignaturaCalificacions;

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
        if (mascota != null) {
            mascota.setEstudiante(this);
        }
    }
}
