package com.itm.clinita.infrastructure.rest.mapper;

import com.itm.clinita.domain.model.Rol;
import com.itm.clinita.infrastructure.rest.dto.response.RolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RolRestMapper {

    private final PermisoRestMapper permisoMapper;

    public RolResponse toResponse(Rol rol) {
        return RolResponse.builder()
                .idRol(rol.getIdRol())
                .nombre(rol.getNombre())
                .descripcion(rol.getDescripcion())
                .permisos(rol.getPermisos().stream()
                        .map(permisoMapper::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
