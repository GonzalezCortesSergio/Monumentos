package com.salesianostriana.dam.monumentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 2)
    private String codigoPais;

    @Column(nullable = false)
    private String nombrePais;

    @Column(nullable = false)
    private String nombreCiudad;

    private double latitud, longitud;

    private String nombreMonumento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;


    @Column(columnDefinition = "TEXT")
    private String photoUrl;

}