package com.zenithdev.caredate.controllers;

import com.zenithdev.caredate.models.Cita;
import com.zenithdev.caredate.models.Paciente;
import com.zenithdev.caredate.repositories.CitaRepository;
import com.zenithdev.caredate.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointment")
@Slf4j
@CrossOrigin
public class CitaController {

    @Autowired
    CitaRepository citaRepository;

    @GetMapping
    public List<Cita> findAll(){
        return citaRepository.findAllByIdCitaNotNullOrderByIdCitaDesc();
    }

    @GetMapping("/findOne")
    public Cita fingById(@RequestParam("id") Integer id){
        return citaRepository.findFirstByIdCita(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Appointment found for id: " + id)
        );
    }

    @PostMapping
    public Cita create(@RequestBody Cita cita){
        cita.setEstatus("Pendiente");
        return citaRepository.save(cita);
    }

    @GetMapping("/dashboard/pending")
    public long countAllPending(){
        return citaRepository.findAllByEstatus("Pendiente").size();
    }

    @GetMapping("/dashboard/cancelled")
    public long countAllCancelled(){
        return citaRepository.findAllByEstatus("Cancelado").size();
    }

    @GetMapping("/dashboard/graph")
    public Map<String, Long> findAllGroupedByStatus(){
        List<Cita> citas = citaRepository.findAll();

        return citas.stream().collect(Collectors.groupingBy(Cita::getEstatus, Collectors.counting()));
    }

    @GetMapping("/dashboard/linegraph")
    public Map<String,Map<String, Long>> findAllGroupedByDate(){
        List<Cita> citas = citaRepository.findAll();
        LocalDateTime date = LocalDateTime.now();

        List<Cita> citasActuales = citas.stream().filter(x -> x.getFechaCita().getYear() == date.getYear()).collect(Collectors.toList());
        List<Cita> citasPasadas = citas.stream().filter(x -> x.getFechaCita().getYear() == date.getYear()-1).collect(Collectors.toList());

        Map<String, Map<String, Long>> response = new HashMap<>();
        response.put("actual", citasActuales.stream().collect(Collectors.groupingBy(x -> x.getFechaCita().getMonth().name(), Collectors.counting())));
        response.put("past", citasPasadas.stream().collect(Collectors.groupingBy(x -> x.getFechaCita().getMonth().name(), Collectors.counting())));


        return response;
    }

}
