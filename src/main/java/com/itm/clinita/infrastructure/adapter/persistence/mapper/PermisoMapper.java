package com.itm.clinita.infrastructure.adapter.persistence.mapper;

import com.itm.clinita.domain.model.Permiso;
import com.itm.clinita.infrastructure.adapter.persistence.entity.PermisoEntity;
import org.springframework.stereotype.Component;

@Component
public class PermisoMapper {

    public Permiso toDomain(PermisoEntity entity) {
        if (entity == null) return null;

        return Permiso.builder()
                .idPermiso(entity.getIdPermiso())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }

    public PermisoEntity toEntity(Permiso domain) {
        if (domain == null) return null;

        return PermisoEntity.builder()
                .idPermiso(domain.getIdPermiso())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .build();
    }
}
