package com.zenithdev.caredate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Pacientes")
@Data
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String nombreContacto;
    private String observaciones;

//    @OneToMany(mappedBy = "paciente")
//    private List<Cita> citas;

}
