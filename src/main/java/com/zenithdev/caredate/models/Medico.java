package com.zenithdev.caredate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Medicos")
@Data
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fechaIngreso;



//    // Otros atributos
//
//    @OneToMany(mappedBy = "medico")
//    private List<Cita> citas;

}
