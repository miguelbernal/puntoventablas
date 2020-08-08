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
@Entity(name = "usuarios")
public class Usuario{
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idUsuario")
    private int idRol;

    @Column(name = "nombre_usuario", length = 128)
    @JsonProperty("nombreUsuario")
    private String nombreUsuario;

    @Column(name = "usuario_usuario", length = 128)
    @JsonProperty("usuarioUsuario")
    private String usuarioUsuario;

    @Column(name = "clave_usuario", length = 128)
    @JsonProperty("claveUsuario")
    private String claveUsuario;


}