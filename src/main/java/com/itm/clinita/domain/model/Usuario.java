package com.itm.clinita.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long idUsuario;
    private String nombreCompleto;
    private String cedula;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String contrasena;
    private Rol rol;
    private Boolean activo;
}