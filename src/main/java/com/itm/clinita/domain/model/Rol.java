package com.itm.clinita.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    private Long idRol;
    private String nombre;
    private String descripcion;
    private List<Permiso> permisos;
}
