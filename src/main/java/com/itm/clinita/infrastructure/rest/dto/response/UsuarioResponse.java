package com.itm.clinita.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private Long idUsuario;
    private String nombreCompleto;
    private String cedula;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private RolResponse rol;
}
