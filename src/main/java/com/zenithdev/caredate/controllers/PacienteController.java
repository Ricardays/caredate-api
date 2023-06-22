package com.zenithdev.caredate.controllers;

import com.zenithdev.caredate.models.Medico;
import com.zenithdev.caredate.models.Paciente;
import com.zenithdev.caredate.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@Slf4j
@CrossOrigin
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteRepository.findAllByIdPacienteNotNullOrderByIdPacienteDesc();
    }


    @PostMapping
    public Paciente create(@RequestBody Paciente paciente){
        paciente.setNombreContacto(paciente.getNombre() + " " + paciente.getApellido());
        return pacienteRepository.save(paciente);
    }

    @GetMapping("/dashboard/created")
    public long countAllCreated(){
        return pacienteRepository.findAll().size();
    }
}
