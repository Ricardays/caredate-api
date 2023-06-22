package com.zenithdev.caredate.repositories;

import com.zenithdev.caredate.models.Medico;
import com.zenithdev.caredate.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}