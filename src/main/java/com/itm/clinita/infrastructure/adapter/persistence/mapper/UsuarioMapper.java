package com.itm.clinita.infrastructure.adapter.persistence.mapper;

import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.infrastructure.adapter.persistence.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final RolMapper rolMapper;

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;

        return Usuario.builder()
                .idUsuario(entity.getIdUsuario())
                .nombreCompleto(entity.getNombreCompleto())
                .cedula(entity.getCedula())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .fechaNacimiento(entity.getFechaNacimiento())
                .direccion(entity.getDireccion())
                .contrasena(entity.getContrasena())
                .activo(entity.getActivo())
                .rol(rolMapper.toDomain(entity.getRol()))
                .build();
    }

    public UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;

        return UsuarioEntity.builder()
                .idUsuario(domain.getIdUsuario())
                .nombreCompleto(domain.getNombreCompleto())
                .cedula(domain.getCedula())
                .correo(domain.getCorreo())
                .telefono(domain.getTelefono())
                .fechaNacimiento(domain.getFechaNacimiento())
                .direccion(domain.getDireccion())
                .contrasena(domain.getContrasena())
                .activo(domain.getActivo())
                .rol(rolMapper.toEntity(domain.getRol()))
                .build();
    }
}
