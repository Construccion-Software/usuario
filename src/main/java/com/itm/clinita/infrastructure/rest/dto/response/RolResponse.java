package com.itm.clinita.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolResponse {
    private Long idRol;
    private String nombre;
    private String descripcion;
    private List<PermisoResponse> permisos;
}
