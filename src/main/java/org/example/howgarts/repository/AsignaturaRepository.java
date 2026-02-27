package org.example.howgarts.repository;

import org.example.howgarts.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository ya trae de fábrica los métodos: save(), findById(), deleteById()...
// Le decimos que maneje "Asignatura" y que su ID es de tipo "Long"
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

}
