package org.example.howgarts.repositories;

import jakarta.persistence.EntityManager;
import org.example.howgarts.model.Estudiante;
import org.example.howgarts.model.Mascota;
import org.example.howgarts.repository.EstudianteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EstudianteRepositoryIntegrationTest {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_debeEliminarMascotaEnCascada() {
        Estudiante est = new Estudiante();
        est.setNombre("Harry");
        est.setAnyoCurso(1L);
        est.setFechaNacimiento(LocalDate.of(1980, 7, 31));

        Mascota mascota = new Mascota();
        mascota.setNombre("Hedwig");
        mascota.setEstudiante(est);
        est.setMascota(mascota);

        Estudiante guardado = estudianteRepository.save(est);
        Long idMascota = guardado.getMascota().getIdMascota();

        estudianteRepository.delete(guardado);

        estudianteRepository.flush();
        entityManager.clear();

        assertFalse(estudianteRepository.findById(guardado.getIdEstudiante()).isPresent());

        Mascota mascotaEnBD = entityManager.find(Mascota.class, idMascota);
        assertNull(mascotaEnBD, "Si Harry se va, todo se va");
    }
}
