package com.itm.clinita.domain.usecase;

import com.itm.clinita.application.command.CrearUsuarioCommand;
import com.itm.clinita.domain.exception.RolNoEncontradoException;
import com.itm.clinita.domain.exception.UsuarioDuplicadoException;
import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.domain.repository.RolRepository;
import com.itm.clinita.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario execute(CrearUsuarioCommand command) {
        // Validar que no exista la cédula
        if (usuarioRepository.existsByCedula(command.getCedula())) {
            throw new UsuarioDuplicadoException(
                    "Ya existe un usuario con la cédula: " + command.getCedula()
            );
        }

        // Validar que no exista el correo
        if (usuarioRepository.existsByCorreo(command.getCorreo())) {
            throw new UsuarioDuplicadoException(
                    "Ya existe un usuario con el correo: " + command.getCorreo()
            );
        }

        // Validar que el rol exista
        var rol = rolRepository.findById(command.getIdRol())
                .orElseThrow(() -> new RolNoEncontradoException(
                        "No se encontró el rol con id: " + command.getIdRol()
                ));

        // Crear el usuario
        var usuario = Usuario.builder()
                .nombreCompleto(command.getNombreCompleto())
                .cedula(command.getCedula())
                .correo(command.getCorreo())
                .telefono(command.getTelefono())
                .fechaNacimiento(command.getFechaNacimiento())
                .direccion(command.getDireccion())
                .contrasena(passwordEncoder.encode(command.getContrasena()))
                .rol(rol)
                .activo(command.getActivo())
                .build();

        return usuarioRepository.save(usuario);
    }
}