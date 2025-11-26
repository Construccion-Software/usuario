package com.itm.clinita.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermisoResponse {
    private Long idPermiso;
    private String nombre;
    private String descripcion;
}
