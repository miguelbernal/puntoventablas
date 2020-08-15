package com.blas.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "departamentos")
public class Departamento {
    @Id
    @Column(name = "id_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idDepartamento")
    private int idDepartamento;
    
    @Column(name = "nombre_departamento", length = 128)
    @JsonProperty("nombreDepartamento")
    private String nombreDepartamento;

    @ManyToOne
    @JsonProperty("pais")
    private Pais pais;
}