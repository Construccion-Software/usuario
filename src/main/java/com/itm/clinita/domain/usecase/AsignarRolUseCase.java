package com.itm.clinita.domain.usecase;

import com.itm.clinita.application.command.AsignarRolCommand;
import com.itm.clinita.domain.exception.RolNoEncontradoException;
import com.itm.clinita.domain.exception.UsuarioNoEncontradoException;
import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.domain.repository.RolRepository;
import com.itm.clinita.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsignarRolUseCase {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Transactional
    public Usuario execute(AsignarRolCommand command) {
        // Buscar el usuario
        var usuario = usuarioRepository.findById(command.getIdUsuario())
                .orElseThrow(() -> new UsuarioNoEncontradoException(
                        "No se encontró el usuario con id: " + command.getIdUsuario()
                ));

        // Buscar el rol
        var rol = rolRepository.findById(command.getIdRol())
                .orElseThrow(() -> new RolNoEncontradoException(
                        "No se encontró el rol con id: " + command.getIdRol()
                ));

        // Asignar el rol
        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }
}