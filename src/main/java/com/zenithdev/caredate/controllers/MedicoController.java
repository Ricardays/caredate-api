package com.zenithdev.caredate.controllers;

import com.zenithdev.caredate.models.Cita;
import com.zenithdev.caredate.models.Medico;
import com.zenithdev.caredate.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/medic")
@Slf4j
@CrossOrigin
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping
    public List<Medico> findAll(){
        return medicoRepository.findAllByIdMedicoNotNullOrderByIdMedicoDesc();
    }

    @PostMapping
    public Medico create(@RequestBody Medico medico){
        medico.setFechaIngreso(LocalDate.now());
        return medicoRepository.save(medico);
    }

    @GetMapping("/dashboard/active")
    public long countAllActive(){
        return medicoRepository.findAll().size();
    }

}
