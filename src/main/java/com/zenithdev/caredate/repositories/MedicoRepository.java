package com.zenithdev.caredate.repositories;

import com.zenithdev.caredate.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findAllByIdMedicoNotNullOrderByIdMedicoDesc();

}