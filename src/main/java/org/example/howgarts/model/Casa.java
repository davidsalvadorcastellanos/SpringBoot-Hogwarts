package org.example.howgarts.model;


import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "id_jefe")
    private Long idJefe;

//    @Column(name = "fantasma")
    private String fantasma;

}
