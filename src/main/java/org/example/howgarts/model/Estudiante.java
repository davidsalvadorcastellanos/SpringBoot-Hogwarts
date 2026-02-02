package org.example.howgarts.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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
    private Long idCurso;

    @Column(name = "anyo_curso")
    private Long anyoCurso;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

}
