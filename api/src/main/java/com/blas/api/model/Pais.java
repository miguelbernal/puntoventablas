package com.blas.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paises")
public class Pais {
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idPais")
    private int idPais;
    
    @Column(name = "nombre_pais", length = 128)
    @JsonProperty("nombrePais")
    private String nombrePais;

    @Column(name = "nacionalidad_pais", length = 128)
    @JsonProperty("nacionalidadPais")
    private String nacionalidadPais;
    
}