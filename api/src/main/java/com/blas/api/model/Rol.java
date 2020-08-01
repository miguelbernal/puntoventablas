package com.blas.api.model;

@Data
@AllArgsContructor
@NoArgsContructor
@Entity
public class Rol{
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idRol")
    private int idRol;

    @Column(name = "nombre_rol", length = 128)
    @JsonProperty("nombreRol")
    private String nombreRol;

}