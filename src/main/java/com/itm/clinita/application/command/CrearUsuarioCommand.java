package com.itm.clinita.application.command;

import com.itm.clinita.domain.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrearUsuarioCommand {
    private Long idUsuario;
    private String nombreCompleto;
    private String cedula;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String contrasena;
    private Long idRol;
    private Boolean activo;
}
