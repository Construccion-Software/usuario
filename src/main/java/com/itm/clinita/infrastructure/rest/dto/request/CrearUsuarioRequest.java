package com.itm.clinita.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrearUsuarioRequest {

    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "La cédula es obligatoria")
    @Size(max = 20, message = "La cédula no puede exceder 20 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "La cédula solo debe contener números")
    private String cedula;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser válido")
    @Size(max = 100, message = "El correo no puede exceder 100 caracteres")
    private String correo;

    @Pattern(regexp = "^[0-9]{1,10}$", message = "El teléfono debe contener entre 1 y 10 dígitos")
    private String telefono;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @Size(max = 100, message = "La dirección no puede exceder 100 caracteres")
    private String direccion;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).*$",
            message = "La contraseña debe incluir mayúscula, número y carácter especial"
    )
    private String contrasena;

    @NotNull(message = "El ID del rol es obligatorio")
    private Long idRol;

    @NotNull(message = "activo es obligatorio (true/false)")
    private Boolean activo;
}
