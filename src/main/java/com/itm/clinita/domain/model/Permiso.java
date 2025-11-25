package com.itm.clinita.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permiso {
    private Long idPermiso;
    private String nombre;
    private String descripcion;
}