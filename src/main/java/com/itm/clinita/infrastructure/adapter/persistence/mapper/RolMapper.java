package com.itm.clinita.infrastructure.adapter.persistence.mapper;

import com.itm.clinita.domain.model.Rol;
import com.itm.clinita.infrastructure.adapter.persistence.entity.RolEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RolMapper {
    private final PermisoMapper permisoMapper;

    public Rol toDomain(RolEntity entity) {
        if (entity == null) return null;

        return Rol.builder()
                .idRol(entity.getIdRol())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .permisos(entity.getPermisos().stream()
                        .map(permisoMapper::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public RolEntity toEntity(Rol domain) {
        if (domain == null) return null;

        return RolEntity.builder()
                .idRol(domain.getIdRol())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .permisos(domain.getPermisos().stream()
                        .map(permisoMapper::toEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
