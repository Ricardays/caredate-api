package com.zenithdev.caredate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Servicios")
@Data
@NoArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    private String nombre;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
}
