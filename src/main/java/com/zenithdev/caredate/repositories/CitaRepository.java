package com.zenithdev.caredate.repositories;

import com.zenithdev.caredate.models.Cita;
import com.zenithdev.caredate.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findAllByIdCitaNotNullOrderByIdCitaDesc();

    List<Cita> findAllByEstatus(String estatus);

    Optional<Cita> findFirstByIdCita(int id);
}