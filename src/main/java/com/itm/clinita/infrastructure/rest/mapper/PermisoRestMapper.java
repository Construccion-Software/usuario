package com.itm.clinita.infrastructure.rest.mapper;

import com.itm.clinita.domain.model.Permiso;
import com.itm.clinita.infrastructure.rest.dto.response.PermisoResponse;
import org.springframework.stereotype.Component;

@Component
public class PermisoRestMapper {

    public PermisoResponse toResponse(Permiso permiso) {
        return PermisoResponse.builder()
                .idPermiso(permiso.getIdPermiso())
                .nombre(permiso.getNombre())
                .descripcion(permiso.getDescripcion())
                .build();
    }
}
