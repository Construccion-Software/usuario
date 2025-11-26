package com.itm.clinita.infrastructure.rest.mapper;

import com.itm.clinita.application.command.CrearUsuarioCommand;
import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.infrastructure.rest.dto.request.CrearUsuarioRequest;
import com.itm.clinita.infrastructure.rest.dto.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRestMapper {

    private final RolRestMapper rolMapper;

    public CrearUsuarioCommand toCommand(CrearUsuarioRequest request) {
        return CrearUsuarioCommand.builder()
                .nombreCompleto(request.getNombreCompleto())
                .cedula(request.getCedula())
                .correo(request.getCorreo())
                .telefono(request.getTelefono())
                .fechaNacimiento(request.getFechaNacimiento())
                .direccion(request.getDireccion())
                .contrasena(request.getContrasena())
                .idRol(request.getIdRol())
                .activo(request.getActivo())
                .build();
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .idUsuario(usuario.getIdUsuario())
                .nombreCompleto(usuario.getNombreCompleto())
                .cedula(usuario.getCedula())
                .correo(usuario.getCorreo())
                .telefono(usuario.getTelefono())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .direccion(usuario.getDireccion())
                .rol(rolMapper.toResponse(usuario.getRol()))
                .build();
    }
}
