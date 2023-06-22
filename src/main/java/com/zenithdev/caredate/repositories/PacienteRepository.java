package com.zenithdev.caredate.repositories;

import com.zenithdev.caredate.models.Medico;
import com.zenithdev.caredate.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findAllByIdPacienteNotNullOrderByIdPacienteDesc();
}