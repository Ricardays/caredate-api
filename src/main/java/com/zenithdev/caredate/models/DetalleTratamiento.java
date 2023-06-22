package com.zenithdev.caredate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Detalle_Tratamientos")
@Data
@NoArgsConstructor
public class DetalleTratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleTratamiento;

    private String medicamento;

    private String posologia;

    @ManyToOne
    @JoinColumn(name = "id_tratamiento")
    private Tratamiento tratamiento;
}
