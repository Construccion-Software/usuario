package com.itm.clinita.domain.usecase;

import com.itm.clinita.domain.exception.UsuarioNoEncontradoException;
import com.itm.clinita.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CambiarEstadoUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void desactivar(Long idUsuario) {
        // Verificar que el usuario existe
        usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(
                        "No se encontró el usuario con id: " + idUsuario
                ));

        usuarioRepository.cambiarEstado(idUsuario, false);
    }

    @Transactional
    public void activar(Long idUsuario) {
        // Verificar que el usuario existe
        usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(
                        "No se encontró el usuario con id: " + idUsuario
                ));

        usuarioRepository.cambiarEstado(idUsuario, true);
    }
}
